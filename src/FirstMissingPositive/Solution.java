package FirstMissingPositive;

class Solution {


    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] == i + 1)
                continue;
            int x = nums[i];
            do {
                if (x > n)
                    break;
                int t = nums[x - 1];
                nums[x - 1] = x;
                x = t;
            } while (x != i);
        }
        for (int i = 0; i < n; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return n + 1;
    }
}
