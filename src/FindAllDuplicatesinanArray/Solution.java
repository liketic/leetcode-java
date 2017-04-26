package FindAllDuplicatesinanArray;


import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and
 * others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example: Input: [4,3,2,7,8,2,3,1]
 *
 * Output: [2,3]
 */
public class Solution {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicatedNums = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            if (v == i + 1) continue;

            // Clear the current number
            nums[i] = 0;

            while (true) {
                int l = v - 1;
                if (nums[l] == v) {
                    duplicatedNums.add(v);
                    break;
                }
                int t = nums[l];
                nums[l] = v;
                v = t;
                if (l == i || v == 0) break;
            }
        }

        return duplicatedNums;
    }
}