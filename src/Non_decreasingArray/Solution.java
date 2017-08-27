package Non_decreasingArray;


public class Solution {
    private boolean canRemove(int[] nums, int i) {
        int x = -1;
        for (int j = 0; j < nums.length; j++) {
            if (j == i) continue;
            if (x == -1) {
                x = j;
                continue;
            }
            if (nums[j] < nums[x]) {
                return false;
            }
            x = j;
        }
        return true;
    }

    public boolean checkPossibility(int[] nums) {
        for (int i = 1, l = nums.length; i < l; i++) {
            if (nums[i] < nums[i - 1]) {
                return canRemove(nums, i) || canRemove(nums, i - 1);
            }
        }
        return true;
    }
}
    