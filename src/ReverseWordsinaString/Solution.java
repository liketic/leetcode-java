package ReverseWordsinaString;


/**
 * Given an input string, reverse the string word by word.
 * <p>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 */
class Solution {

    private void reverse(char[] arr, int s, int e) {
        for (int i = s, j = e; i < j; i++, j--) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }

    public String reverseWords(String s) {
        if (s == null)
            return null;
        char[] asChars = s.toCharArray();
        int len = asChars.length;

        reverse(asChars, 0, len - 1);

        int index = 0;
        for (int i = 0; i < len; i++) {
            if ((i < len - 1 && Character.isWhitespace(asChars[i + 1])) || i == len - 1) {
                if (i >= index) {
                    reverse(asChars, index, i);
                }
                index = i + 2;
            }
        }
        // I think this logic is absolutely unrelated. Why should we 
        // care about the whitespace here?
        int offset = 0;
        boolean skipWs = false;
        for (int i = 0; i < len; i++) {
            if (Character.isWhitespace(asChars[i])) {
                skipWs = true;
            } else {
                if (skipWs && offset > 0) {
                    asChars[offset++] = ' ';
                    skipWs = false;
                }
                asChars[offset++] = asChars[i];
            }
        }
        return new String(asChars, 0, offset);
    }
}