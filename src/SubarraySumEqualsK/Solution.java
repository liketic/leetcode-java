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

        Map<Integer, Integer> countOfSum = new HashMap<>();
        int ans = 0;
        int sum = 0;
        countOfSum.put(sum, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int offset = sum - k;
            ans += countOfSum.getOrDefault(offset, 0);
            countOfSum.put(sum, countOfSum.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }
}