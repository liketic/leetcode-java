package RemoveDuplicatesfromSortedArrayII;


/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements
 * of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave
 * beyond the new length.
 */
class Solution {

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (!(index > 0 && nums[i] == nums[index] && nums[i] == nums[index - 1])) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}