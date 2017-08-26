package SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k, you need to find the total number of continuous
 * subarrays whose sum equals to k.
 */
class Solution {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return 0;

        Map<Integer, Integer> sum2Indexs = new HashMap<>();
        int[] sum = new int[n];
        int ans = 0;
        sum2Indexs.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum[i] = i == 0 ? nums[i] : nums[i] + sum[i - 1];
            int offset = sum[i] - k;
            ans += sum2Indexs.getOrDefault(offset, 0);
            sum2Indexs.put(sum[i], sum2Indexs.getOrDefault(sum[i], 0) + 1);
        }

        return ans;
    }
}