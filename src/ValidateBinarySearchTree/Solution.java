package ValidateBinarySearchTree;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int max(TreeNode root) {
        while (root.right != null)
            root = root.right;
        return root.val;
    }

    private int min(TreeNode root) {
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (!isValidBST(root.left) || !isValidBST(root.right))
            return false;
        if ((root.left == null || max(root.left) < root.val)
                && (root.right == null || root.val < min(root.right)))
            return true;
        return false;
    }
}