package SummaryRanges;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <pre>
 * Example 1:
 * Input: [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Example 2:
 * Input: [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * </pre>
 */
class Solution {

    private static String toRange(int l, int r) {
        if (l == r) {
            return "" + l;
        }
        return l + "->" + r;
    }

    public List<String> summaryRanges(int[] nums) {
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                l = nums[i];
            } else if (nums[i] != nums[i - 1] + 1) {
                ranges.add(toRange(l, r));
                l = nums[i];
            }
            r = nums[i];
        }
        if (r >= l) {
            ranges.add(toRange(l, r));
        }
        return ranges;
    }
}