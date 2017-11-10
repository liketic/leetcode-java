package UniquePathsII;

/**
 * Follow up for "Unique Paths":
 * <p>
 * Now consider if some obstacles are added to the grids. How many
 * unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <pre>
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * </pre>
 * Note: m and n will be at most 100.
 */
class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numRow = obstacleGrid.length;
        if (numRow == 0)
            return 0;
        int numCol = obstacleGrid[0].length;
        if (numCol == 0)
            return 0;

        int[][] numPaths = new int[numRow][numCol];
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (obstacleGrid[i][j] == 1) {
                    numPaths[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    numPaths[i][j] = 1;
                } else if (i == 0) {
                    numPaths[i][j] = numPaths[i][j - 1];
                } else if (j == 0) {
                    numPaths[i][j] = numPaths[i - 1][j];
                } else {
                    numPaths[i][j] = numPaths[i - 1][j] + numPaths[i][j - 1];
                }
            }
        }
        return numPaths[numRow - 1][numCol - 1];
    }
}