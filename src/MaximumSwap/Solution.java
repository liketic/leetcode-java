package MaximumSwap;

class Solution {

    private int digitsToInt(int[] digits, int n) {
        int v = 0;
        for (int i = n - 1; i >= 0; i--) {
            v = v * 10 + digits[i];
        }
        return v;
    }

    private void swap(int[] digits, int i, int j) {
        if (i != j) {
            int t = digits[i];
            digits[i] = digits[j];
            digits[j] = t;
        }
    }

    public int maximumSwap(int num) {
        if (num == 0) return 0;
        int[] digits = new int[10];
        int k = 0;
        // It's possible no any swap
        int max = num;

        while (num > 0) {
            digits[k] = num % 10;
            num /= 10;
            ++k;
        }

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (digits[i] > digits[j]) {
                    swap(digits, i, j);
                    int newNum = digitsToInt(digits, k);
                    if (max < newNum)
                        max = newNum;
                    swap(digits, i, j);
                }
            }
        }
        return max;
    }
}