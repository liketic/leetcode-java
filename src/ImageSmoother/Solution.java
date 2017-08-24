package ImageSmoother;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a
 * smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of
 * all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as
 * many as you can.
 */
class Solution {

    public int[][] imageSmoother(int[][] M) {
        int n = M.length;
        int m = M[0].length;
        int[][] x = new int[n][m];

        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int s = 0;
                int c = 0;
                for (int k = 0; k < 9; k++) {
                    int px = i + dx[k], py = j + dy[k];
                    if (px >= 0 && px < n && py >= 0 && py < m) {
                        s += M[px][py];
                        c++;
                    }
                }
                x[i][j] = s / c;
            }
        }
        return x;
    }
}