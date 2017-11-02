package PermutationsII;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <pre>
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * </pre>
 */
class Solution {

    private boolean permuteNums(int[] nums) {
        int n = nums.length;
        int minimum = -1, loc = -1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j] && (loc == -1 || minimum > nums[j])) {
                    minimum = nums[j];
                    loc = j;
                }
            }
            if (loc > -1) {
                int t = nums[i];
                nums[i] = nums[loc];
                nums[loc] = t;
                Arrays.sort(nums, i + 1, n);
                return true;
            }
        }
        return false;
    }

    private List<Integer> array2List(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    private List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> permutations = new ArrayList<>();
        Arrays.sort(nums);
        permutations.add(array2List(nums));

        while (permuteNums(nums)) {
            permutations.add(array2List(nums));
        }
        return permutations;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        // Just use the same solution as problem Permutations
        return permute(nums);
    }
}