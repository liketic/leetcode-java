package FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does
 * not count as extra space.
 *
 * Example:
 * <pre>
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 * </pre>
 */
class Solution {

    private int locationOf(int v) {
        return v - 1;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            while (true) {
                int l = locationOf(n);
                if (nums[l] == n) break;
                int t = nums[l];
                nums[l] = n;
                n = t;
                if (l == i) break;
            }
        }
        List<Integer> disappeared = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (locationOf(nums[i]) != i) {
                disappeared.add(i + 1);
            }
        }
        return disappeared;
    }
}