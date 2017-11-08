package MaximumLengthofRepeatedSubarray;


/**
 * Given two integer arrays A and B, return the maximum length of an subarray that
 * appears in both arrays.
 * <pre>
 * Example 1:
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * Note:
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * </pre>
 */
class Solution {

    public int findLength(int[] A, int[] B) {
        int l, r;
        l = A.length;
        r = B.length;
        int[][] count = new int[l][r];

        int s = 0;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                if (A[i] == B[j]) {
                    count[i][j] = 1 + (i > 0 && j > 0 ? count[i - 1][j - 1] : 0);
                } else {
                    count[i][j] = 0;
                }
                if (s < count[i][j])
                    s = count[i][j];
            }
        }
        return s;
    }
}