package LongestUnivaluePath;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    
    private int longestUnivaluePath(TreeNode root, int v) {
        if (root == null || root.val != v) {
            return 0;
        }
        return Math.max(longestUnivaluePath(root.left, v), longestUnivaluePath(root.right, v)) + 1;
    }
    
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(longestUnivaluePath(root.left), longestUnivaluePath(root.right));
        int r = longestUnivaluePath(root.left, root.val) + longestUnivaluePath(root.right, root.val) + 1;
        return Math.max(l, r);
    }
}