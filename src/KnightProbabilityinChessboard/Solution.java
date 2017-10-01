package KnightProbabilityinChessboard;


class Solution {

    private static final int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    private static final int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    
    private boolean isOut(int r, int c, int N) {
        return !(r >= 0 && r < N && c >= 0 && c < N);
    }

    public double knightProbability(int N, int K, int r, int c) {
        if (K == 0) {
            return 1.0;
        }
        double[][] b = new double[N][N];
        double[][] b2 = new double[N][N];

        b[r][c] = 1.0;

        for (int i = 0; i < K; i++) {
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    b2[x][y] = 0.0;
                }
            }
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (b[x][y] == 0.0) {
                        continue;
                    }
                    for (int j = 0; j < 8; j++) {
                        int f1 = x + dx[j], f2 = y + dy[j];
                        if (!isOut(f1, f2, N)) {
                            b2[f1][f2] += b[x][y] / 8.0;
                        }
                    }
                }
            }
            double[][] t = b;
            b = b2;
            b2 = t;
        }

        double v = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                v += b[i][j];
        }
        return v;
    }

}
