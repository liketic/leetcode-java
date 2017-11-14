package LongestIncreasingSubsequence;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * For example,
 * Given [10, 9, 2, 5, 3, 7, 101, 18],
 * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 * Note that there may be more than one LIS combination, it is only necessary for you
 * to return the length.
 * <p>
 * Your algorithm should run in O(n2) complexity.
 * <p>
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
class Solution {

    public int lengthOfLIS(int[] nums) {
        // TODO O(nlog(n))
        
        int n = nums.length;
        int[] lis = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && lis[j] < lis[i] + 1) {
                    lis[j] = lis[i] + 1;
                }
            }
            if (s < lis[i])
                s = lis[i];
        }
        return s;
    }
}