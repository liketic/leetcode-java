package _3SumClosest;


import java.util.Arrays;

/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given
 * number, target. Return the sum of the three integers. You may assume that each input would have
 * exactly one Solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
class Solution {
    
    public int threeSumClosest(int[] nums, int target) {
        // Sort the array first
        Arrays.sort(nums);

        int n = nums.length;
        int closest = 0, offset = 0;
        boolean found = false;

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
                    if (sum == target) {
                        return sum;
                    } else if (sum > target) {
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }


                for (int k = r; k <= l; k++) {
                    if (k > j && k < n) {
                        if (!found) {
                            // The first valid number
                            closest = v + nums[k];
                            offset = Math.abs(target - closest);
                            found = true;
                        } else if (offset > Math.abs(target - v - nums[k])) {
                            closest = v + nums[k];
                            offset = Math.abs(target - closest);
                        }
                    }
                }
            }
        }
        return closest;
    }
}