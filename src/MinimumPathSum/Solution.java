package MinimumPathSum;

/**
 * Given a m x n grid filled with non-negative numbers, find a path
 * from top left to bottom right which minimizes the sum of all numbers
 * along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <pre>
 * Example 1:
 * [[1,3,1],
 * [1,5,1],
 * [4,2,1]]
 * Given the above grid map, return 7. Because the path 1→3→1→1→1 minimizes the sum.
 * </pre>
 */
class Solution {

    public int minPathSum(int[][] grid) {
        int numRow = grid.length;
        if (numRow == 0)
            return 0;
        int numCol = grid[0].length;
        if (numCol == 0)
            return 0;

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i > 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else if (i > 0) {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[numRow - 1][numCol - 1];
    }
}