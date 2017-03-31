package ValidParentheses;


/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
 * input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]"
 * are not.
 */
public class Solution2 {

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

    public boolean isValid(String s) {
        int n = s.length();
        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (isOpen(ch)) {
                top++;
                stack[top] = ch;
                continue;
            }
            if (top < 0) return false;
            if (ch == closeFor(stack[top])) {
                top--;
                continue;
            }
            return false;
        }
        return top == -1;
    }
}