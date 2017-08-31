package Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 */
class Solution {
    public List<List<Integer>> combine(int n, int k) {

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        List<List<Integer>> ans = new ArrayList<>();

        int count;
        for (int i = 1; i < (1 << n); i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    count++;
                    if (count > k) break;
                }
            }
            if (count != k)
                continue;
            List<Integer> r = new ArrayList<>(k);
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    r.add(arr[j]);
                }
            }
            ans.add(r);
        }
        return ans;
    }
}