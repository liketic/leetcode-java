package NumberofIslands;

class Solution {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean insideGrid(int x, int y, int numRow, int numCol) {
        return (x >= 0 && x < numRow && y >= 0 && y < numCol);
    }

    private void floodFill(char[][] grid, int x, int y, int numRow, int numCol) {
        if (grid[x][y] <= 0)
            return;
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i];
            int ly = y + dy[i];
            if (insideGrid(lx, ly, numRow, numCol) && grid[lx][ly] == '1') {
                floodFill(grid, lx, ly, numRow, numCol);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int numRow = grid.length;
        if (numRow == 0)
            return 0;
        int numCol = grid[0].length;
        if (numCol == 0)
            return 0;
        int numIsland = 0;

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (grid[i][j] == '1') {
                    ++numIsland;
                    floodFill(grid, i, j, numRow, numCol);
                }
            }
        }
        return numIsland;
    }
}