package MaxAreaofIsland;


class Solution {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean insideGrid(int x, int y, int numRow, int numCol) {
        return (x >= 0 && x < numRow && y >= 0 && y < numCol);
    }

    private int floodFill(int[][] grid, int x, int y, int numRow, int numCol) {
        if (grid[x][y] == 0)
            return 0;
        int v = 1;
        grid[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i];
            int ly = y + dy[i];
            if (insideGrid(lx, ly, numRow, numCol) && grid[lx][ly] == 1) {
                v += floodFill(grid, lx, ly, numRow, numCol);
            }
        }
        return v;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int numRow = grid.length;
        if (numRow == 0) return 0;
        int numCol = grid[0].length;
        if (numCol == 0)
            return 0;

        int rv = 0;

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (grid[i][j] == 1) {
                    rv = Math.max(rv, floodFill(grid, i, j, numRow, numCol));
                }
            }
        }
        return rv;
    }
}