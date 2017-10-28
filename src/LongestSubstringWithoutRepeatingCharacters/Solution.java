package LongestSubstringWithoutRepeatingCharacters;


/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 * substring, "pwke" is a subsequence and not a substring.
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int[] index = new int[256];
        int r = 0;

        for (int i = 0, n = s.length(); i < n; i++) {
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