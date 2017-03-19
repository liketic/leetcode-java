package SearchinRotatedSortedArray;


/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return
 * -1.
 *
 * You may assume no duplicate exists in the array.
 */
public class Solution {

    
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            if (l == r) {
                return nums[r] == target ? r : -1;
            }
            int m = (l + r) / 2;
            if (nums[l] <= nums[m]) {
                if (target <= nums[m] && target >= nums[l]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= nums[m] || target >= nums[l]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
        }
        return -1;
    }
}