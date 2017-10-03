package _2KeysKeyboard;

class Solution {


    public int minSteps(int n) {
        int[] count = new int[n + 1];
        count[1] = 0;

        for (int i = 2; i <= n; i++) {
            count[i] = Integer.MAX_VALUE;
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    // Copy the first i 'A' and paste (i / j) - 1 times.
                    count[i] = Math.min(count[i], count[j] + ((i / j)));
                }
            }
        }
        return count[n];
    }
}