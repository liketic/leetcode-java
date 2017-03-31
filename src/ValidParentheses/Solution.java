package ValidParentheses;


/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]"
 * are not.
 */
public class Solution {

    private char closeFor(char ch) {
        switch (ch) {
            case '(':
                return ')';
            case '[':
                return ']';
            case '{':
                return '}';
        }
        return '-';
    }

    private boolean isOpen(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }

    private boolean isValid(char[] chars, int s, int e) {
        if (s > e) return true;
        for (int i = s; i <= e; ) {
            char ch = chars[i];
            if (isOpen(ch)) {
                int x = 1, j = i + 1;
                char close = closeFor(ch);

                for (; j <= e; j++) {
                    if (chars[j] == ch) x++;
                    else if (chars[j] == close) {
                        x--;
                        if (x == 0) {
                            break;
                        }
                    }
                }
                if (j > e || !isValid(chars, s + 1, e - 1)) {
                    return false;
                }
                i = j + 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isValid(String s) {
        int n = s.length();
        return isValid(s.toCharArray(), 0, n - 1);
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()"));
    }
}