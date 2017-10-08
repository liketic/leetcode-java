package _132Pattern;

import java.util.Stack;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such
 * that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and
 * checks whether there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 * <pre>
 * Example 1:
 * Input: [1, 2, 3, 4]
 *
 * Output: False
 *
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 *
 * Output: True
 *
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 *
 * Output: True
 * </pre>
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2,
 * 0].
 */
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int two = Integer.MIN_VALUE; // 2

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < two) {
                // s must be not empty now. num[i] is 1
                return true;
            } else {
                while (!s.isEmpty() && nums[i] > s.peek()) {
                    two = s.pop();
                }
                s.push(nums[i]);
            }
        }
        return false;
    }
}