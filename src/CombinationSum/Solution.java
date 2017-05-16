package CombinationSum;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all
 * unique combinations in C where the candidate numbers sums to T.
 *
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * <pre>
 * All numbers (including target) will be positive integers.
 * The Solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A Solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * </pre>
 */
public class Solution {

    private List<List<Integer>> dfs(int[] candidates, int target, int pos, List<Integer> nums) {
        List<List<Integer>> rv = new ArrayList<>();
        if (pos == candidates.length) {
            if (target == 0) {
                rv.add(nums);
            }
            return rv;
        }
        for (int i = 0; candidates[pos] * i <= target; i++) {
            if (i > 0) {
                nums.add(candidates[pos]);
            }
            rv.addAll(dfs(candidates, target - candidates[pos] * i, pos + 1, new ArrayList<>(nums)));
        }
        return rv;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return dfs(candidates, target, 0, new ArrayList<>());
    }
}