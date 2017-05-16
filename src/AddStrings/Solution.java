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
public class Solution {


    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }
        int left = 0;
        char[] arr = new char[num1.length() + 1];
        int k = 0;

        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0; i--, j--) {
            int v = (num1.charAt(i) - '0') + left;
            if (j >= 0) {
                v += (num2.charAt(j) - '0');
            }
            left = v / 10;
            v %= 10;
            arr[k++] = (char) (v + '0');
        }
        if (left > 0) {
            arr[k++] = (char) (left + '0');
        }
        StringBuilder sum = new StringBuilder(k);
        for (int i = k - 1; i >= 0; i--) {
            sum.append(arr[i]);
        }
        return sum.toString();
    }
}