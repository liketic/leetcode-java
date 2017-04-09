package SpiralMatrixII;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * For example,
 * Given n = 3,
 *
 * You should return the following matrix:
 * <pre>
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 * </pre>
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }

        int r = 0, c = 0;
        int pos = 1;

        while (n > 0) {
            for (int i = c; i < c + n; i++) {
                matrix[r][i] = pos++;
            }
            for (int j = r + 1; j < r + n; j++) {
                matrix[j][c + n - 1] = pos++;
            }
            if (n > 1) {
                for (int i = c + n - 2; i >= c; i--) {
                    matrix[r + n - 1][i] = pos++;
                }
                for (int j = r + n - 2; j > r; j--) {
                    matrix[j][c] = pos++;
                }
            }
            n -= 2;
            r++;
            c++;
        }

        return matrix;
    }
}