package RemoveDuplicatesfromSortedArray;


/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and
 * return the new length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * <pre>
 * For example,
 * Given input array nums = [1,1,2],
 * </pre>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively. It doesn't matter what you leave beyond the new length.
 *
 * Subscribe to see which companies asked this question.
 */
class Solution {

    public int removeDuplicates(int[] nums) {
        int pos = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[pos]) {
                nums[++pos] = nums[i];
            }
        }
        return pos + 1;
    }
}