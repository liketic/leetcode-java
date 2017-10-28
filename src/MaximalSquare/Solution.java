package MaximalSquare;


class Solution {


    public int maximalSquare(char[][] matrix) {
        if (matrix == null)
            return 0;
        int numRow = matrix.length;
        if (numRow == 0)
            return 0;
        int numCol = matrix[0].length;
        int s = 0;

        int[][] count2D = new int[numRow][numCol];

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                int c = matrix[i][j] == '1' ? 1 : 0;
                if (i == 0 && j == 0) {
                    count2D[i][j] = c;
                } else if (i == 0) {
                    count2D[i][j] = c + count2D[i][j - 1];
                } else if (j == 0) {
                    count2D[i][j] = c + count2D[i - 1][j];
                } else {
                    count2D[i][j] = c + count2D[i - 1][j] + count2D[i][j - 1] - count2D[i - 1][j - 1];
                }

                if (c == 0) continue;

                for (int w = 1; i + 1 - w >= 0 && j + 1 - w >= 0; w++) {
                    int x = i - w, y = j - w;
                    int sum = count2D[i][j];
                    if (x >= 0) sum -= count2D[x][j];
                    if (y >= 0) sum -= count2D[i][y];
                    if (x >= 0 && y >= 0) sum += count2D[x][y];
                    if (sum == w * w && s < sum) {
                        s = sum;
                    }
                }
            }
        }

        return s;
    }
}