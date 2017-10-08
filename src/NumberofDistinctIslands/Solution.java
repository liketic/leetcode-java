package NumberofDistinctIslands;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean insideGrid(int x, int y, int numRow, int numCol) {
        return (x >= 0 && x < numRow && y >= 0 && y < numCol);
    }

    private int floodFill(int[][] grid, int x, int y, int numRow, int numCol) {
        if (grid[x][y] <= 0)
            return 0;
        grid[x][y] = -1;
        int v = 1;
        for (int i = 0; i < 4; i++) {
            int lx = x + dx[i];
            int ly = y + dy[i];
            if (insideGrid(lx, ly, numRow, numCol) && grid[lx][ly] == 1) {
                v += floodFill(grid, lx, ly, numRow, numCol);
            }
        }
        return v;
    }

    private static class Island {
        int x, y, size;

        Island(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    private boolean checkIsSame(int lx, int ly, int rx, int ry, int[][] grid, int numRow, int numCol) {
        if (grid[lx][ly] != grid[rx][ry])
            return false;
        if (grid[lx][ly] == 0)
            return true;
        grid[lx][ly] = grid[rx][ry] = 0;

        for (int i = 0; i < 4; i++) {
            int dlx = lx + dx[i], dly = ly + dy[i];
            int drx = rx + dx[i], dry = ry + dy[i];
            if (insideGrid(dlx, dly, numRow, numCol) && insideGrid(drx, dry, numRow, numCol)) {
                if (!checkIsSame(dlx, dly, drx, dry, grid, numRow, numCol)) {
                    return false;
                }
            } else if (insideGrid(dlx, dly, numRow, numCol) && grid[dlx][dly] != 0) {
                return false;
            } else if (insideGrid(drx, dry, numRow, numCol) && grid[drx][dry] != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSame(Island a, Island b, int[][] grid, int numRow, int numCol) {
        return a.size == b.size && checkIsSame(a.x, a.y, b.x, b.y, grid, numRow, numCol);
    }

    private List<Island> findIslands(int[][] grid, int numRow, int numCol) {
        List<Island> islands = new ArrayList<>();
        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (grid[i][j] == 1) {
                    int size = floodFill(grid, i, j, numRow, numCol);
                    islands.add(new Island(i, j, size));
                }
            }
        }
        return islands;
    }

    public int numDistinctIslands(int[][] grid) {
        int numRow = grid.length;
        if (numRow == 0) return 0;
        int numCol = grid[0].length;
        if (numCol == 0)
            return 0;

        List<Island> islands = findIslands(grid, numRow, numCol);
        if (islands.isEmpty())
            return 0;

        List<Island> uniqueIslands = new ArrayList<>();
        for (Island island : islands) {
            boolean hasSame = false;
            for (Island uniqueIsland : uniqueIslands) {
                int[][] grid2 = new int[numRow][numCol];
                for (int x = 0; x < numRow; x++) {
                    System.arraycopy(grid[x], 0, grid2[x], 0, numCol);
                }
                if (isSame(island, uniqueIsland, grid2, numRow, numCol)) {
                    hasSame = true;
                    break;
                }
            }
            if (!hasSame) {
                uniqueIslands.add(island);
            }
        }
        return uniqueIslands.size();
    }
}