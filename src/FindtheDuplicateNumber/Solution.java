package FindtheDuplicateNumber;


class Solution {


    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            nums[i] = -1;

            while (true) {
                if (nums[v - 1] == v) {
                    return v;
                } else if (nums[v - 1] == -1) {
                    nums[v - 1] = v;
                    break;
                }
                int x = nums[v - 1];
                nums[v - 1] = v;
                v = x;
            }
        }
        return -1;
    }
}