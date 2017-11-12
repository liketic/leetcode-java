package MinimumWindowSubsequence;


class Solution {

    public String minWindow(String S, String T) {
        int n, l;
        n = S.length();
        l = T.length();
        int[][] dp = new int[n][l];

        int s, e, len = Integer.MAX_VALUE;
        s = e = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < l; j++) {
                if (S.charAt(i) == T.charAt(j)) {
                    dp[i][j] = 1 + (i > 0 && j > 0 ? dp[i - 1][j - 1] : 0);
                } else {
                    dp[i][j] = Math.max(
                            i > 0 ? dp[i - 1][j] : 0,
                            j > 0 ? dp[i][j - 1] : 0
                    );
                }
            }
            if (dp[i][l - 1] == l) {
                // Go back to find the substring length
                int j = i, k = l - 1;
                while (k >= 0) {
                    if (S.charAt(j) == T.charAt(k)) {
                        k--;
                    }
                    j--;
                }
                if (len > i - j) {
                    len = i - j;
                    s = j + 1;
                    e = i;
                }
            }
        }
        if (len < Integer.MAX_VALUE) {
            return S.substring(s, e + 1);
        }
        return "";
    }

}