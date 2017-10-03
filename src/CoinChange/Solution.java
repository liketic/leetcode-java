package CoinChange;


class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++)
            dp[i] = Integer.MAX_VALUE;
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            for (int j : coins) {
                long v = (long) i + j;
                if (v <= amount) {
                    dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}