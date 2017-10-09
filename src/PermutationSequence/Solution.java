package PermutationSequence;

import java.util.Arrays;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * <pre>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"</pre>
 * Given n and k, return the kth permutation sequence.
 *
 * Note: Given n will be between 1 and 9 inclusive.
 */
class Solution {

    public String getPermutation(int n, int k) {
        int total = 1;
        for (int i = 1; i <= n; i++) {
            total *= i;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        String r = "";
        int pos = 0, left = n;

        while (k > 0) {
            total /= left;
            left--;

            for (int i = pos; i < n; i++) {
                if ((i - pos + 1) * total >= k) {
                    r += nums[i];
                    // Remove the ith number from nums
                    if (i != pos) nums[i] = nums[pos];
                    k -= (i - pos) * total;

                    pos++;
                    Arrays.sort(nums, pos, n);

                    break;
                }
            }
            if (left == 0) break;
        }

        return r;
    }

}