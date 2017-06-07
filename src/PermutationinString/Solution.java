package PermutationinString;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of
 * s1. In other words, one of the first string's permutations is the substring of the second
 * string.
 * <pre>
 * Example 1:
 * Input:s1 = "ab" s2 = "eidbaooo"
 * Output:True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * Note:
 * The input strings only contain lower case letters.
 * The length of both given strings is in range [1, 10,000].
 * </pre>
 */
public class Solution {

    private int loc(char ch) {
        return ch - 'a';
    }

    private boolean moreThan(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] < b[i]) return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] cs1 = new int[26];
        for (char ch : s1.toCharArray()) {
            cs1[loc(ch)]++;
        }

        int l = s1.length();
        int n = s2.length();
        int[][] cs2 = new int[n + 1][26];

        for (int i = 1; i <= n; i++) {
            cs2[i][loc(s2.charAt(i - 1))]++;

            for (int k = 0; k < 26; k++) {
                cs2[i][k] += cs2[i - 1][k];
            }

            if (moreThan(cs2[i], cs1)) {
                boolean ok = true;
                for (int k = 0; k < 26; k++) {
                    if (cs2[i][k] - cs2[i - l][k] != cs1[k]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
            }
        }
        return false;
    }
}