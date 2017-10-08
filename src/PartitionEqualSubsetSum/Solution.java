package PartitionEqualSubsetSum;

/**
 * Given a non-empty array containing only positive integers, find if the array can be partitioned
 * into two subsets such that the sum of elements in both subsets is equal.
 * <pre>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 * </pre>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
class Solution {
    
    public boolean canPartition(int[] nums) {
        int[] v = new int[101];
        int sum = 0;
        for (int n : nums) {
            v[n]++;
            sum += n;
        }

        if (sum % 2 == 1) return false;

        boolean[] flag = new boolean[sum / 2 + 1];
        flag[0] = true;

        for (int i = 0; i <= 100; i++) {
            for (int k = sum / 2; k >= 0; k--) {
                for (int j = 0; j <= v[i]; j++) {
                    if (k >= j * i && flag[k - j * i]) {
                        flag[k] = true;
                    }
                }
            }
        }

        return flag[sum / 2];
    }
}