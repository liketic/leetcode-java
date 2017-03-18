package LongestPalindromicSubstring;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 */
public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int n = s.length();
        
        // If there is no any palindromic substring, return the first character.
        int start = 0, end = 0;

        int maximum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i - 1, k = i + 1; j >= 0 && k < n; k++, j--) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (maximum < (k - j + 1)) {
                    maximum = k - j + 1;
                    start = j;
                    end = k;
                }
            }
            for (int j = i, k = i + 1; j >= 0 && k < n; k++, j--) {
                if (s.charAt(j) != s.charAt(k)) {
                    break;
                }
                if (maximum < (k - j + 1)) {
                    maximum = k - j + 1;
                    start = j;
                    end = k;
                }
            }
        }

        return s.substring(start, end + 1);
    }
    
    
    public static void main(String args[]) {
        String s = "abc";
        System.out.println(new Solution().longestPalindrome(s));
    }
}