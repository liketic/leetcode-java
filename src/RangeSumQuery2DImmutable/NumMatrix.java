package RangeSumQuery2DImmutable;

/**
 * Given a 2D matrix matrix, find the sum of the elements inside
 * the rectangle defined by its upper left corner (row1, col1)
 * and lower right corner (row2, col2).
 * <p>
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
class NumMatrix {

    private int[][] matrixSum;
    private int[][] matrix;

    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    private void calculateSum() {
        int n = matrix.length;
        if (n == 0) {
            matrixSum = new int[0][0];
            return;
        }
        int numCol = matrix[0].length;
        matrixSum = new int[n][numCol];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < numCol; j++) {
                matrixSum[i][j] = matrix[i][j];
                if (j > 0)
                    matrixSum[i][j] += matrixSum[i][j - 1];
                if (i > 0)
                    matrixSum[i][j] += matrixSum[i - 1][j];
                if (i > 0 && j > 0)
                    matrixSum[i][j] -= matrixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (matrixSum == null)
            calculateSum();
        int s = matrixSum[row2][col2];
        if (col1 > 0)
            s -= matrixSum[row2][col1 - 1];
        if (row1 > 0)
            s -= matrixSum[row1 - 1][col2];
        if (col1 > 0 && row1 > 0)
            s += matrixSum[row1 - 1][col1 - 1];
        return s;
    }
}
