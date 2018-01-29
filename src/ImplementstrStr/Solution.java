package ImplementstrStr;

class Solution {
    
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        if (needle.isEmpty())
            return 0;
        for (int i = 0, l = haystack.length(), k = needle.length(); i < l; i++) {
            boolean match = true;
            for (int j = 0; j < k; j++) {
                if (i + j >= l || haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match)
                return i;
        }
        return -1;
    }
}