package SearchinRotatedSortedArrayII;

/**
 * Suppose an array sorted in ascending order is rotated at some
 * pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * Write a function to determine if a given target is in the array.
 * <p>
 * The array may contain duplicates.
 */
class Solution {

    private boolean search(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                return true;
            if (nums[l] < nums[m]) {
                if (nums[l] <= target && target <= nums[m])
                    r = m - 1;
                else
                    l = m + 1;
            } else if (nums[m] < nums[r]) {
                if (nums[m] <= target && target <= nums[r])
                    l = m + 1;
                else
                    r = m - 1;
            } else {
                // if nums[l] == nums[m] == nums[r], actually we don't 
                // know which side target located in.
                return search(nums, target, l, m - 1) || search(nums, target, m + 1, r);
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }
}