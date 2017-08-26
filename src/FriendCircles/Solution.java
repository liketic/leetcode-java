package FriendCircles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * There are N students in a class. Some of them are friends, while some are not. Their friendship
 * is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of
 * C, then A is an indirect friend of C. And we defined a friend circle is a group of students who
 * are direct or indirect friends.
 *
 * Given a N*N matrix M representing the friend relationship between students in the class. If
 * M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And
 * you have to output the total number of friend circles among all the students.
 */
class Solution {


    private void floodFill(int[][] M, int n, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);

        while (!queue.isEmpty()) {
            Integer row = queue.poll();
            for (int k = 0; k < n; k++) {
                if (M[row][k] == 1) {
                    M[row][k] = 0;
                    queue.add(k);
                }
            }
        }
    }


    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0) return 0;
        int r = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    r++;
                    floodFill(M, n, i);
                    break;
                }
            }
        }
        return r;
    }
}