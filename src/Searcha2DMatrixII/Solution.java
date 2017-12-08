package Searcha2DMatrixII;

class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int n;
        if ((n = matrix.length) == 0)
            return false;
        int w = matrix[0].length;

        int r = 0, c = w - 1;
        while (r < n && c >= 0) {
            if (matrix[r][c] == target)
                return true;
            if (matrix[r][c] < target)
                r++;
            else
                c--;
        }
        return false;
    }
}