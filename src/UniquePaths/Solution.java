package UniquePaths;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 */
class Solution {

    public int uniquePaths(int m, int n) {
        int[][] numPaths = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    numPaths[i][j] = 1;
                    continue;
                }
                numPaths[i][j] = 0;
                if (i > 0) numPaths[i][j] += numPaths[i - 1][j];
                if (j > 0) numPaths[i][j] += numPaths[i][j - 1];
            }
        }
        return numPaths[m - 1][n - 1];
    }
}
