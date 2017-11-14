package CountNumberswithUniqueDigits;


class Solution {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            // 0 can be the first digit only if n == 1
            return 10;
        } else {
            int count = 10;
            for (int i = 2; i <= n; i++) {
                int s = 9;
                int t = 9;
                for (int j = 1; j < i; j++)
                    s *= t--;
                count += s;
            }
            return count;
        }
    }
}