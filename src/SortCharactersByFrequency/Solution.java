package SortCharactersByFrequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * <pre>
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * </pre>
 */
class Solution {

    public String frequencySort(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int[] nums = new int[count.size()];
        int n = 0;
        for (Map.Entry<Character, Integer> e : count.entrySet()) {
            nums[n++] = e.getValue();
        }
        Arrays.sort(nums);

        StringBuilder builder = new StringBuilder(s.length());

        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && nums[i] == nums[i + 1]) {
                continue;
            }
            for (Map.Entry<Character, Integer> e : count.entrySet()) {
                if (e.getValue().equals(nums[i])) {
                    for (int j = 0; j < nums[i]; j++) {
                        builder.append(e.getKey());
                    }
                }
            }
        }

        return builder.toString();
    }
}
