package MagicalString;

/**
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 *
 * The string S is magical because concatenating the number of contiguous occurrences of characters
 * '1' and '2' generates the string S itself.
 *
 * The first few elements of string S is the following: S = "1221121221221121122……"
 *
 * If we group the consecutive '1's and '2's in S, it will be:
 *
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 *
 * and the occurrences of '1's or '2's in each group are:
 *
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 *
 * You can see that the occurrence sequence above is the S itself.
 *
 * Given an integer N as input, return the number of '1's in the first N number in the magical
 * string S.
 *
 * Note: N will not exceed 100,000.
 * <pre>
 * Example 1:
 * Input: 6
 * Output: 3
 * </pre>
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so
 * return 3.
 */
public class Solution {
    public int magicalString(int n) {
        if (n <= 3) return 1;
        int r = 1;
        int[] x = new int[n + 1];
        x[1] = 1;
        x[2] = x[3] = 2;
        int dup = 1;
        boolean isOne = false;

        for (int i = 4; i <= n; ) {
            int l = x[i - dup];
            for (int j = i; j <= n && j < i + l; j++) {
                x[j] = isOne ? 2 : 1;
                if (!isOne) r++;
            }
            i += l;
            if (l > 1) dup++;
            isOne = !isOne;
        }
        return r;
    }
}