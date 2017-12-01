package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
 * in C where the candidate numbers sums to T.
 *
 * Each number in C may only be used once in the combination.
 *
 * Note: All numbers (including target) will be positive integers. The Solution set must not contain
 * duplicate combinations. For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, A
 * Solution set is:
 * <pre>
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 * </pre>
 */
class Solution {

    private List<List<Integer>> dfs(int[] candidates, int[] count, int target, int pos, List<Integer> nums) {
        List<List<Integer>> rv = new ArrayList<>();
        if (pos == -1) {
            if (target == 0) {
                rv.add(nums);
            }
            return rv;
        }
        if (target < 0) return rv;
        for (int i = 0; i <= count[pos]; i++) {
            if (i > 0) {
                nums.add(candidates[pos]);
                target -= candidates[pos];
                if (target < 0) break;
            }
            rv.addAll(dfs(candidates, count, target, pos - 1, new ArrayList<>(nums)));
        }
        return rv;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        if (n == 0) {
            return Collections.emptyList();
        }

        Arrays.sort(candidates);

        int[] nums = new int[n];
        int[] count = new int[n];
        int k = 0;
        nums[0] = candidates[0];
        count[0] = 1;

        for (int i = 1; i < n; i++) {
            if (candidates[i] != nums[k]) {
                nums[++k] = candidates[i];
                count[k] = 1;
            } else {
                count[k]++;
            }
        }
        return dfs(nums, count, target, k, new ArrayList<>());
    }
}