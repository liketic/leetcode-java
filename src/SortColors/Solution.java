package SortColors;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue
 * respectively.
 */
class Solution {

    private static int[] COLOR = new int[]{0, 1, 2};


    public void sortColors(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        int k = 0;

        for (int i = 0; i <= COLOR.length; i++) {
            for (int j = k; j < n; j++) {
                if (nums[j] != COLOR[i])
                    continue;
                if (k != j) {
                    int t = nums[k];
                    nums[k] = nums[j];
                    nums[j] = t;
                }
                k++;
            }
        }
    }
}