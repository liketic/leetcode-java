package AddStrings;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and
 * num2.
 *
 * Note:
 * <pre>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * </pre>
 */
class Solution {

    private int char2Int(char ch) {
        return ch - '0';
    }

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int left = 0;
        // The result at most num1.length() + 1 digits
        int[] digits = new int[num1.length() + 1];
        int k = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0; i--, j--) {
            int v = char2Int(num1.charAt(i)) + left;
            if (j >= 0) {
                // The length of num2 maybe less than num1
                v += char2Int(num2.charAt(j));
            }
            left = v / 10;
            v %= 10;
            digits[k++] = v;
        }
        if (left > 0) {
            digits[k++] = left;
        }
        StringBuilder sum = new StringBuilder(k);
        for (int i = k - 1; i >= 0; i--) {
            sum.append(digits[i]);
        }
        return sum.toString();
    }
}