package MaximumSubarray;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the
 * largest sum.
 *
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4], the contiguous subarray [4,-1,2,1] has the
 * largest sum = 6.
 *
 * click to show more practice.
 *
 * More practice: If you have figured out the O(n) solution, try coding another solution using the
 * divide and conquer approach, which is more subtle.
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        long sum = 0;
        long maximum = -Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            maximum = Math.max(maximum, sum);
            if (sum < 0) sum = 0;
        }

        return (int) maximum;
    }
}