package MonotoneIncreasingDigits;

class Solution {

    public int monotoneIncreasingDigits(int N) {
        int[] digits = new int[10];
        int n = 0;
        while (N > 0) {
            digits[n++] = N % 10;
            N /= 10;
        }

        while (true) {
            boolean isMid = true;
            for (int i = n - 1; i > 0; i--) {
                if (digits[i] > digits[i - 1]) {
                    isMid = false;
                    digits[i]--;
                    for (int j = i - 1; j >= 0; j--)
                        digits[j] = 9;
                    break;
                }
            }
            if (isMid)
                break;
        }
        int i = n - 1, v = 0;
        while (i >= 0 && digits[i] == 0)
            --i;
        while (i >= 0)
            v = v * 10 + digits[i--];
        return v;
    }
}