package SplitArrayintoConsecutiveSubsequences;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an integer array sorted in ascending order (may contain duplicates), you need to
 * split them into several subsequences, where each subsequences consist of at least 3 consecutive
 * integers. Return whether you can make such a split.
 *
 * Example 1: Input: [1,2,3,3,4,5] Output: True Explanation: You can split them into two consecutive
 * subsequences :
 * <pre>
 * 1, 2, 3
 * 3, 4, 5
 * </pre>
 * Example 2:
 * <pre>
 * Input: [1,2,3,3,4,4,5,5]
 * Output: True
 * </pre>
 * Explanation: You can split them into two consecutive subsequences :
 * <pre>
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * Example 3:
 * Input: [1,2,3,4,4,5]
 * Output: False
 * </pre>
 * Note: The length of the input is in range of [1, 10000]
 */
class Solution {

    public boolean isPossible(int[] nums) {
        List<List<Integer>> group = new ArrayList<>();

        for (int i = 0, l = nums.length; i < l; i++) {
            int val = nums[i];
            int len = Integer.MAX_VALUE;
            int pos = -1;

            for (int j = 0, lg = group.size(); j < lg; j++) {
                List<Integer> arr = group.get(j);
                int n = arr.size();
                if (arr.get(n - 1) == val - 1 && len > n) {
                    len = n;
                    pos = j;
                } else if (n < 3 && arr.get(n - 1) < val - 1) {
                    // No possible to construct a seq
                    return false;
                }
            }
            if (pos == -1) {
                List<Integer> arr = new ArrayList<>();
                arr.add(val);
                group.add(arr);
            } else {
                group.get(pos).add(val);
            }
        }
        for (int i = 0, l = group.size(); i < l; i++) {
            if (group.get(i).size() < 3)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
    }
}