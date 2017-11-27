package ArrayNesting;

import java.util.HashMap;
import java.util.Map;

/**
 * A zero-indexed array A consisting of N different integers is given. The array contains all
 * integers in the range [0, N - 1].
 * <p>
 * Sets S[K] for 0 <= K < N are defined as follows:
 * <p>
 * S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.
 * <p>
 * Sets S[K] are finite for each K and should NOT contain duplicates.
 * <p>
 * Write a function that given an array A consisting of N integers, return the size of the largest
 * set S[K] for this array.
 */

class Solution {

    public int arrayNesting(int[] nums) {
        int r = 0;
        Map<Integer, Boolean> flag = new HashMap<>();

        for (int num : nums) {
            int k = num;
            int t = 0;
            while (!flag.containsKey(k)) {
                flag.put(k, true);
                t++;
                k = nums[k];
            }
            if (r < t)
                r = t;
        }

        return r;
    }
}