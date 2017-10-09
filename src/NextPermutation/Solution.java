package NextPermutation;


import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater
 * permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie,
 * sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in
 * the right-hand column.
 *
 * <pre>
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * </pre>
 */
class Solution {

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        int loc = -1, toSwap = 0;

        for (int i = n - 1; i > 0; i--) {
            int j = i - 1;
            for (; j > loc; j--) {
                if (nums[j] < nums[i]) {
                    break;
                }
            }
            if (j > loc) {
                loc = j;
                toSwap = i;
            }
        }

        if (loc == -1) {
            // If no such number found, which means the numbers are ordered
            // from big to small.
            Arrays.sort(nums);
        } else {
            // Find the last number which less than num[i], then swap
            // these two values and sort numbers after this position.
            int v = nums[loc];
            nums[loc] = nums[toSwap];
            nums[toSwap] = v;
            Arrays.sort(nums, loc + 1, n);
        }
    }
}