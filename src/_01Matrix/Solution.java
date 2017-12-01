package _01Matrix;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 * Example 1:
 * <pre>
 * Input:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Output:
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * Example 2:
 * Input:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * Output:
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 * </pre>
 */
class Solution {

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static class Node {
        int x, y, s;

        Node(int x, int y, int s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    private boolean isInMatrix(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }

    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] r = new int[m][n];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    Node node = new Node(i, j, 0);
                    queue.add(node);
                    r[i][j] = 0;
                } else {
                    r[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = node.x + dx[i];
                int y = node.y + dy[i];
                int s = node.s + 1;
                if (!isInMatrix(x, y, m, n)) {
                    continue;
                }
                if (r[x][y] == Integer.MAX_VALUE) {
                    r[x][y] = s;
                    queue.add(new Node(x, y, s));
                }
            }
        }

        return r;
    }
}