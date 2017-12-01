package SpiralMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral
 * order.
 *
 * For example, Given the following matrix:
 *
 * <pre>
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * </pre>
 * You should return [1,2,3,6,9,8,7,4,5].
 */ 
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return Collections.emptyList();
        }
        int n = matrix[0].length;
        List<Integer> rv = new ArrayList<>();

        int r = 0, c = 0;

        while (n > 0 && m > 0) {
            for (int i = c; i < c + n; i++) {
                rv.add(matrix[r][i]);
            }
            for (int j = r + 1; j < r + m; j++) {
                rv.add(matrix[j][c + n - 1]);
            }
            if (m > 1) {
                for (int i = c + n - 2; i >= c; i--) {
                    rv.add(matrix[r + m - 1][i]);
                }
            }
            if (n > 1) {
                for (int j = r + m - 2; j > r; j--) {
                    rv.add(matrix[j][c]);
                }
            }
            n -= 2;
            m -= 2;
            r++;
            c++;
        }

        return rv;
    }
}
