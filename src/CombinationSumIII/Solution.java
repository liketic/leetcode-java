package CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given
 * that only numbers from 1 to 9 can be used and each combination should be a
 * unique set of numbers.
 * <p>
 * <pre>
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * </pre>
 */
class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> resultSet = new ArrayList<>();

        int c, sum;
        for (int i = 1; i <= (1 << 9) - 1; i++) {
            c = sum = 0;
            for (int j = 1; j <= 9; j++) {
                if ((i & (1 << (j - 1))) > 0) {
                    c++;
                    sum += j;
                    if (c > k || sum > n) break;
                }
            }
            if (c == k && sum == n) {
                List<Integer> arr = new ArrayList<>(k);
                for (int j = 1; j <= 9; j++) {
                    if ((i & (1 << (j - 1))) > 0) {
                        arr.add(j);
                    }
                }
                resultSet.add(arr);
            }
        }
        return resultSet;
    }
}