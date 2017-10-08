package _4SumII;

import java.util.Arrays;

/**
 * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are
 * such that A[i] + B[j] + C[k] + D[l] is zero.
 *
 * To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All
 * integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.
 *
 * Example:
 * <pre>
 * Input:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two tuples are:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * </pre>
 */
class Solution {

    private int lowerBound(int[] arr, int n, int target) {
        int l = 0, r = n;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l < n && arr[l] == target ? l : -1;
    }

    private int upperBound(int[] arr, int n, int target) {
        int l = 0, r = n - 1;
        int s = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] == target) {
                s = Math.max(m, s);
                l = m + 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return s;
    }

    private int count(int[] arr, int n, int target) {
        int l = lowerBound(arr, n, target);
        if (l < 0) return 0;
        int r = upperBound(arr, n, target);
        if (r < 0) return 0;
        return (r - l + 1);
    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = 0;
        int[] sumOfAB = new int[A.length * B.length];
        for (int aA : A) {
            for (int aB : B) {
                sumOfAB[n++] = aA + aB;
            }
        }
        Arrays.sort(sumOfAB);

        int ans = 0;
        for (int cn : C) {
            for (int dn : D) {
                ans += count(sumOfAB, n, (cn + dn) * -1);
            }
        }

        return ans;
    }

}
