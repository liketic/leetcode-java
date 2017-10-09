package DeleteOperationforTwoStrings;

/**
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and
 * word2 the same, where in each step you can delete one character in either string.
 *
 * <pre>
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * The length of given words won't exceed 500.
 * Characters in given words can only be lower-case letters.
 * </pre>
 */
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int l = word2.length();

        int[][] dp = new int[n + 1][l + 1];
        
        // The left string must be the LCS
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= l; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (n + l - dp[n][l] * 2);
    }
}