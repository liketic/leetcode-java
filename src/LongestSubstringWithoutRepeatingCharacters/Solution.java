package LongestSubstringWithoutRepeatingCharacters;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] index = new int[256];
        int r = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 256; j++) {
                index[j] = 0;
            }
            int len = 0;
            for (int j = i; j < n; j++) {
                int ch = (int) s.charAt(j);
                if (index[ch] > 0) {
                    break;
                }
                index[ch] = 1;
                len++;
            }
            r = Math.max(r, len);
        }
        return r;
    }
}