package FloodFill;


class Solution {

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private boolean inside(int[][] image, int sr, int sc) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[sr].length;
    }

    private void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        image[sr][sc] = newColor;
        for (int j = 0; j < 4; j++) {
            int x = sr + dx[j];
            int y = sc + dy[j];
            if (inside(image, x, y) && image[x][y] == oldColor) {
                floodFill(image, x, y, oldColor, newColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            floodFill(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
}

