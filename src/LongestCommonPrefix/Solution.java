package LongestCommonPrefix;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != str.charAt(i)) {
                    return str.substring(0, i);
                }
            }
        }
        return str;
    }
}