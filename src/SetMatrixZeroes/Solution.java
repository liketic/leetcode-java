package SetMatrixZeroes;


class Solution {


    public void setZeroes(int[][] matrix) {
        int numRow = matrix.length;
        if (numRow == 0)
            return;
        int numCol = matrix[0].length;

        boolean[] rowIsZeros = new boolean[numRow];
        boolean[] colIsZeros = new boolean[numCol];
        boolean[][] visited = new boolean[numRow][numCol];

        for (int i = 0; i < numRow; i++) {
            for (int j = 0; j < numCol; j++) {
                if (matrix[i][j] != 0 || visited[i][j])
                    continue;
                if (!rowIsZeros[i]) {
                    rowIsZeros[i] = true;
                    for (int k = 0; k < numCol; k++) {
                        if (matrix[i][k] != 0)
                            visited[i][k] = true;
                        matrix[i][k] = 0;
                    }
                }
                if (!colIsZeros[j]) {
                    colIsZeros[j] = true;
                    for (int k = 0; k < numRow; k++) {
                        if (matrix[k][j] != 0)
                            visited[k][j] = true;
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}
