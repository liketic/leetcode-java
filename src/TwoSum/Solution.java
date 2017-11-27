package TwoSum;


/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target.
 * <p>
 * You may assume that each input would have exactly one Solution, and you may not use the same
 * element twice.
 * <p>
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}