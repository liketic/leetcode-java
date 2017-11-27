package ThirdMaximumNumber;

import java.util.Arrays;

/**
 * Given a non-empty array of integers, return the third maximum number in this array. If it does
 * not exist, return the maximum number. The time complexity must be in O(n).
 * <pre>
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 *
 * </pre>
 * Both numbers with value 2 are both considered as second maximum.
 */
class Solution {

    public int thirdMax(int[] nums) {
        int[] topThree = new int[3];
        int n = 0;

        for (int num : nums) {
            boolean existing = false;
            for (int i = 0; i < n; i++) {
                if (topThree[i] == num) {
                    existing = true;
                    break;
                }
            }
            if (existing) continue;

            if (n < 3) {
                topThree[n++] = num;
            } else if (topThree[0] < num) {
                topThree[0] = num;
            }
            Arrays.sort(topThree, 0, 3);
        }
        return n < 3 ? topThree[n - 1] : topThree[0];
    }
}