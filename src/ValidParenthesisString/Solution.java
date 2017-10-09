package ValidParenthesisString;


/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to
 * check whether this string is valid. We define the validity of a string by these rules:
 * <pre>
 * 1.Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2.Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3.Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an
 * empty string.
 * 4.An empty string is also valid.
 * </pre>
 */
class Solution {

    private boolean match(char ch, char other) {
        return (ch == '(' || ch == '*') && (other == ')' || other == '*');
    }

    private int check(int l, int r, int[][] dp, char[] chars) {
        if (l > r) {
            // The string is empty
            return 1;
        }
        if (dp[l][r] != 0) {
            // Already calculated for [l, r]
            return dp[l][r];
        }
        if (l == r) {
            dp[l][r] = chars[l] == '*' ? 1 : -1;
        } else {
            if (match(chars[l], chars[r]) && check(l + 1, r - 1, dp, chars) == 1) {
                dp[l][r] = 1;
            } else {
                dp[l][r] = -1;
                for (int i = l; i < r; i++) {
                    if (check(l, i, dp, chars) == 1 && check(i + 1, r, dp, chars) == 1) {
                        dp[l][r] = 1;
                        break;
                    }
                }
            }
        }
        return dp[l][r];
    }

    public boolean checkValidString(String s) {
        int n = s.length();
        // dp is a 2D-array, for each [l, r], if it's match then dp[l][r] = 1
        // otherwise dp[l][r] = -1. 
        int[][] dp = new int[n][n];
        return check(0, n - 1, dp, s.toCharArray()) == 1;
    }
}