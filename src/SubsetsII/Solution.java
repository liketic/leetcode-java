package SubsetsII;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Given a collection of integers that might contain duplicates,
 * nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * For example,
 * If nums = [1,2,2], a solution is:
 * <p>
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 */
class Solution {

    private boolean checkExists(List<List<Integer>> subsets, List<Integer> subset) {
        for (int i = subsets.size() - 1; i >= 0; i--) {
            List<Integer> subsetAt = subsets.get(i);
            int n = subsetAt.size();
            if (n != subset.size())
                continue;
            boolean equals = true;
            for (int j = 0; j < n; j++) {
                if (!Objects.equals(subsetAt.get(j), subset.get(j))) {
                    equals = false;
                    break;
                }
            }
            if (equals)
                return true;
        }
        return false;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    c++;
                }
            }
            List<Integer> subset = new ArrayList<>(c);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(nums[j]);
                }
            }
            Collections.sort(subset);
            if (!checkExists(subsets, subset))
                subsets.add(subset);
        }
        return subsets;
    }
}