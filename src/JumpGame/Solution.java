package JumpGame;


/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * For example:
 * <pre>
 * A = [2,3,1,1,4], return true.
 *
 * A = [3,2,1,0,4], return false.
 * </pre>
 */
class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPos = 0;

        for (int i = 0; i < n; i++) {
            if (i == 0 || i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
            }
        }

        return maxPos >= n - 1;
    }
}