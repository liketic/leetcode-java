package CircularArrayLoop;


class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0)
                // Already visited
                continue;

            int v = nums[i];
            nums[i] = 0;
            int s = i;
            int count = 1;

            // Direction cannot be different
            boolean isNeg = v < 0;

            while (true) {
                int j = Math.floorMod(s + v, n);
                if (nums[j] == 0) {
                    // reach the start point and count grater than 1
                    if (count > 1 && j == i) return true;
                    break;
                }
                boolean isNeg2 = nums[j] < 0;
                if (isNeg != isNeg2)
                    break;

                v = nums[j];
                nums[j] = 0;
                count++;
                s = j;
            }
        }
        return false;
    }
}