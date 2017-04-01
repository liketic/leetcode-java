package LongestPalindromicSubsequence;


public class Solution {

    private int[][] dp;

    private int longestPalindromeSubseqFor(char[] chars, int l, int r) {
        if (l > r) return 0;
        if (dp[l][r] > 0) return dp[l][r];
        if (chars[l] == chars[r]) {
            dp[l][r] = longestPalindromeSubseqFor(chars, l + 1, r - 1) + 2;
        } else {
            dp[l][r] = Math.max(longestPalindromeSubseqFor(chars, l, r - 1),
                    longestPalindromeSubseqFor(chars, l + 1, r));
        }
        return dp[l][r];
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return longestPalindromeSubseqFor(s.toCharArray(), 0, n - 1);
    }
}