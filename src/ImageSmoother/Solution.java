package ImageSmoother;

/**
 * Given a 2D integer matrix M representing the gray scale of an image, you need to design a
 * smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of
 * all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as
 * many as you can.
 */
class Solution {

    public int[][] imageSmoother(int[][] M) {
        int rowNums = M.length;
        int colNums = M[0].length;
        int[][] matrix = new int[rowNums][colNums];

        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < rowNums; i++) {
            for (int j = 0; j < colNums; j++) {
                int sum = 0;
                int count = 0;

                for (int k = 0; k < 9; k++) {
                    int px = i + dx[k], py = j + dy[k];
                    if (px >= 0 && px < rowNums && py >= 0 && py < colNums) {
                        sum += M[px][py];
                        count++;
                    }
                }
                matrix[i][j] = sum / count;
            }
        }
        return matrix;
    }
}