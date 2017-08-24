package EqualTreePartition;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int total(TreeNode root) {
        if (root == null) return 0;
        return total(root.left) + total(root.right) + root.val;
    }

    private boolean checkEqualTree(TreeNode root, int v) {
        if (root == null) return false;
        int t = total(root);
        if (t == v) return true;
        return checkEqualTree(root.left, v) || checkEqualTree(root.right, v);
    }

    public boolean checkEqualTree(TreeNode root) {
        int t = total(root);
        if (t % 2 != 0) return false;
        t /= 2;
        return checkEqualTree(root.left, t) || checkEqualTree(root.right, t);
    }
}