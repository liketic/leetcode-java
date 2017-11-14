package PerfectSquares;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        int[] minimum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            // Avoid overflow
            minimum[i] = Integer.MAX_VALUE / 2;

            for (int s : squares) {
                if (s > i)
                    break;
                if (minimum[i] > minimum[i - s] + 1)
                    minimum[i] = minimum[i - s] + 1;
            }
        }

        return minimum[n];
    }
}