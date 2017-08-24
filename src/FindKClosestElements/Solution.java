package FindKClosestElements;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The
 * result should also be sorted in ascending order. If there is a tie, the smaller elements are
 * always preferred.
 *
 * Example 1:
 * <pre>
 * Input: [1,2,3,4,5], k=4, x=3
 * Output: [1,2,3,4]
 * Example 2:
 * Input: [1,2,3,4,5], k=4, x=-1
 * Output: [1,2,3,4]
 * Note:
 * The value k is positive and will always be smaller than the length of the sorted array.
 * Length of the given array is positive and will not exceed 104
 * Absolute value of elements in the array and x will not exceed 104
 * </pre>
 */
class Solution {

    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int n = arr.size();
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            int v = arr.get(m);
            if (v == x) {
                l = m + 1;
                r = m;
                break;
            } else if (v > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        int t = r;
        r = l;
        l = t;

        while (k > 0) {
            if (l < 0) {
                result.addAll(arr.subList(r, r + k));
                break;
            } else if (r >= n) {
                result.addAll(arr.subList(l - k + 1, l + 1));
                break;
            } else {
                int a = arr.get(l), b = arr.get(r);
                if (Math.abs(a - x) <= Math.abs(b - x)) {
                    result.add(a);
                    l--;
                } else {
                    result.add(b);
                    r++;
                }
            }
            k--;
        }
        result.sort(Integer::compareTo);
        return result;
    }
}