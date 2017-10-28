package MinimumSizeSubarraySum;


class Solution {


    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length];
        int rv = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum[i] = nums[i] + (i > 0 ? sum[i - 1] : 0);
            
            // Finding the largest index so that sum of [index, i] >= s
            int l = 0, r = i;
            while (l <= r) {
                int m = (l + r) / 2;

                if (sum[i] - sum[m] + nums[m] >= s) {
                    if (rv > i - m + 1) {
                        rv = i - m + 1;
                    }
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        return rv == Integer.MAX_VALUE ? 0 : rv;
    }
}