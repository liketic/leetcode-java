package MaximumLengthofPairChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given n pairs of numbers. In every pair, the first number is always smaller than the
 * second number.
 *
 * Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs
 * can be formed in this fashion.
 *
 * Given a set of pairs, find the length longest chain which can be formed. You needn't use up all
 * the given pairs. You can select pairs in any order.
 */
class Solution {

    private static class Pair {
        int l, r;
    }

    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        if (n == 0) return 0;

        List<Pair> asList = new ArrayList<>(n);
        for (int[] pair : pairs) {
            Pair p = new Pair();
            p.l = pair[0];
            p.r = pair[1];
            asList.add(p);
        }
        asList.sort((o1, o2) -> {
            if (o1.r == o2.r)
                return o1.l < o2.l ? -1 : (o1.l == o2.l ? 0 : 1);
            return o1.r < o2.r ? -1 : 1;
        });

        Map<Integer, Integer> ans = new HashMap<>();
        int r = 0;

        for (int i = 0; i < n; i++) {
            Pair cur = asList.get(i);
            int s = 1;

            for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
                if (entry.getKey() < cur.l) {
                    s = Math.max(entry.getValue() + 1, s);
                }
            }
            ans.put(cur.r, s);
            r = Math.max(r, s);
        }

        return r;
    }
}