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
public class Solution {
    public int thirdMax(int[] nums) {
        int[] maxs = new int[3];
        int n = 0;

        for (int num : nums) {
            boolean in = false;
            for (int i = 0; i < n; i++) {
                if (maxs[i] == num) {
                    in = true;
                    break;
                }
            }
            if (in) continue;

            if (n < 3) {
                maxs[n++] = num;
            } else {
                maxs[0] = Math.max(maxs[0], num);
            }
            Arrays.sort(maxs, 0, 3);
        }
        return n < 3 ? maxs[n - 1] : maxs[0];
    }
}