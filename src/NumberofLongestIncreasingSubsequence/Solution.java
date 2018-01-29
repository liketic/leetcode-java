package NumberofLongestIncreasingSubsequence;


class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int[] lis = new int[n];
        int[] count = new int[n];

        int maxLis = 0, r = 0;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && max < lis[j])
                    max = lis[j];
            }
            if (max > 0) {
                lis[i] = max + 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i] && max == lis[j])
                        count[i] += count[j];
                }
            } else {
                lis[i] = 1;
                count[i] = 1;
            }
            maxLis = Math.max(maxLis, lis[i]);
        }

        for (int i = 0; i < n; i++)
            if (maxLis == lis[i])
                r += count[i];
        return r;
    }
}