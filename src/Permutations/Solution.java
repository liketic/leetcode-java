package Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 *
 * <pre>
 * For example,
 * [1,2,3] have the following permutations:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
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

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> permutations = new ArrayList<>();
        if (n == 0) {
            return permutations;
        }
        Arrays.sort(nums);
        permutations.add(array2List(nums));

        while (true) {
            // Find next permutation
            if (!permuteNums(nums)) break;
            permutations.add(array2List(nums));
        }
        return permutations;
    }
}