package BeautifulArrangement;


class Solution {

    private int dfs(int n, boolean[] vis, int k) {
        if (k > n)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && (i % k == 0 || k % i == 0)) {
                vis[i] = true;
                count += dfs(n, vis, k + 1);
                vis[i] = false;
            }
        }
        return count;
    }

    public int countArrangement(int N) {
        boolean[] vis = new boolean[N + 1];
        return dfs(N, vis, 1);
    }
}