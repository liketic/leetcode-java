package GenerateParentheses;


import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * For example, given n = 3, a Solution set is:
 * <pre>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * </pre>
 */
public class Solution {

    private List<String> dfs(int left, int open, String prefix) {
        List<String> r = new ArrayList<>();
        if (left < open) {
            // The left positions is more than opened parentheses
            return r;
        }
        if (left == 1) {
            // The last position must be ")"
            if (open == 1) {
                r.add(prefix + ")");
            }
            return r;
        }
        List<String> openResult = dfs(left - 1, open + 1, prefix + "(");
        if (open > 0) {
            List<String> closeResult = dfs(left - 1, open - 1, prefix + ")");
            openResult.addAll(closeResult);
        }
        return openResult;
    }

    public List<String> generateParenthesis(int n) {
        // The first position must be "("
        return dfs(n * 2 - 1, 1, "(");
    }
}