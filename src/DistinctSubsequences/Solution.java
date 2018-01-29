package DistinctSubsequences;


/**
 * Given a string S and a string T, count the number of distinct
 * subsequences of S which equals T.
 * <p>
 * A subsequence of a string is a new string which is formed from
 * the original string by deleting some (can be none) of the
 * characters without disturbing the relative positions of the
 * remaining characters. (ie, "ACE" is a subsequence of "ABCDE"
 * while "AEC" is not).
 * <p>
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * <p>
 * Return 3.
 */
class Solution {
    public int numDistinct(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        int[][] dp = new int[lens + 1][lent + 1];

        int count = 0;
        dp[0][0] = 1;

        for (int i = 1; i <= lens; i++) {
            for (int j = 1; j <= lent; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] += dp[k][j - 1];
                    }
                }
            }
            count += dp[i][lent];
        }
        return count;
    }
}