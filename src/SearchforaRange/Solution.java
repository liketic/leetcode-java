package SearchforaRange;


/**
 * Given an array of integers sorted in ascending order, find the starting and ending position of a
 * given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * <pre>
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * </pre>
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] rv = new int[2];
        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        if (r < 0 || nums[r] != target) {
            // The target not existed in nums
            rv[0] = rv[1] = -1;
            return rv;
        }
        
        rv[1] = r;

        l = 0;
        r = n - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        rv[0] = l;
        return rv;
    }
}