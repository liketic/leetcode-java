package ValidSquare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct
 * a square.
 * <p>
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 * <p>
 * Example:
 * <pre>
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * </pre>
 * <p>
 * Note:
 * <pre>
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree
 * angles).
 * Input points have no order.
 * </pre>
 */
class Solution {

    private void swap(int[] x, int i, int j) {
        if (i != j) {
            int t = x[i];
            x[i] = x[j];
            x[j] = t;
        }
    }

    private void permute(int[] x, int i, List<int[]> result) {
        if (i == 4) {
            int[] y = Arrays.copyOf(x, 4);
            result.add(y);
            return;
        }
        for (int j = i; j < 4; j++) {
            swap(x, i, j);
            permute(x, i + 1, result);
            swap(x, i, j);
        }
    }

    private int calculateDistance(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }

    private boolean check(int[][] points, int[] orders) {
        int prev = -1;
        for (int i = 0; i < 4; i++) {
            int t = calculateDistance(points[orders[i]], points[orders[(i + 1) % 4]]);
            if (t == 0)
                return false;
            if (prev < 0)
                prev = t;
            else if (prev != t) {
                return false;
            }
        }
        int a = calculateDistance(points[orders[0]], points[orders[2]]);
        int b = calculateDistance(points[orders[1]], points[orders[3]]);
        return (a == b && a > 0);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] x = new int[]{0, 1, 2, 3};
        List<int[]> perms = new ArrayList<>();
        permute(x, 0, perms);

        int[][] points = {p1, p2, p3, p4};

        for (int[] perm : perms) {
            if (check(points, perm)) {
                return true;
            }
        }
        return false;
    }

}