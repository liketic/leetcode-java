package CombinationSumIV;


/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * <p>
 * <pre>
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 * </pre>
 */
class Solution {


    public int combinationSum4(int[] nums, int target) {
        int[] count = new int[target + 1];
        count[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                if (i + num <= target) {
                    count[i + num] += count[i];
                }
            }
        }
        return count[target];
    }
}