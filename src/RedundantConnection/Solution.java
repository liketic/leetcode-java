package RedundantConnection;


class Solution {

    private static class DisjointSet {
        // Parent node for each node
        private int[] parent;
        // Tree height for tree which root is each node
        private int[] rank;

        DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        int find(int v) {
            while (parent[v] != v) {
                v = parent[v];
            }
            return v;
        }

        boolean check(int a, int b) {
            return find(a) == find(b);
        }

        void union(int a, int b) {
            int x = find(a);
            int y = find(b);
            if (x == y) {
                return;
            }
            if (rank[x] < rank[y]) {
                parent[x] = y;
            } else if (rank[x] > rank[y]) {
                parent[y] = x;
            } else {
                parent[x] = y;
                // Increment the height of y
                rank[y]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int numEdge = edges.length;
        DisjointSet disjointSet = new DisjointSet(numEdge);
        for (int[] edge : edges) {
            if (disjointSet.check(edge[0], edge[1])) {
                return edge;
            }
            disjointSet.union(edge[0], edge[1]);
        }
        // Should never happen
        return new int[]{};
    }
}