package SingleElementinaSortedArray;


/**
 * Given a sorted array consisting of only integers where every element appears twice except for one
 * element which appears once. Find this single element that appears only once.
 * <pre>
 * Example 1:
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 * </pre>
 * Note: Your Solution should run in O(log n) time and O(1) space.
 */
class Solution {

    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int l = 0, r = n - 1;

        while (l <= r) {
            if (l == r) {
                return nums[r];
            }
            int m = (l + r) / 2;
            if ((m + 1) % 2 == 0) {
                if (nums[m] == nums[m - 1]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if (nums[m] == nums[m + 1]) {
                    l = m + 2;
                } else {
                    r = m;
                }
            }
        }
        // This shouldn't happen
        return -1;
    }
}