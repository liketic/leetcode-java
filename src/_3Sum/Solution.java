package _3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all
 * unique triplets in the array which gives the sum of zero.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);

        int n = nums.length;

        List<List<Integer>> resultSet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // Avoid duplicated i
                continue;
            }
            
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // Avoid duplicated i
                    continue;
                }
                int v = nums[i] + nums[j];

                // Find all k if nums[i] + nums[j] + nums[k] == 0
                int l = j + 1, r = n - 1, m = -1;

                while (l <= r) {
                    m = (l + r) / 2;
                    int sum = v + nums[m];
                    if (sum == 0) {
                        break;
                    } else if (sum > 0) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                if (m > j && m < n && v + nums[m] == 0) {
                    // A valid m found
                    List<Integer> rv = new ArrayList<>();
                    rv.add(nums[i]);
                    rv.add(nums[j]);
                    rv.add(nums[m]);
                    resultSet.add(rv);
                }
            }
        }
        return resultSet;
    }
}