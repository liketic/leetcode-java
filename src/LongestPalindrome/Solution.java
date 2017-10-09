package LongestPalindrome;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest
 * palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note: Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * <pre>
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * </pre>
 */
class Solution {

    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char ch : s.toCharArray()) {
            counts[ch]++;
        }
        int len = 0;
        boolean hasSingle = false;

        for (int i = 0; i < 128; i++) {
            if (counts[i] % 2 == 0) {
                len += counts[i];
            } else {
                hasSingle = true;
                len += counts[i] - 1;
            }
        }
        return len + (hasSingle ? 1 : 0);
    }
}