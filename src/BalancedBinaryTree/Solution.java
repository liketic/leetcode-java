package BalancedBinaryTree;


/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {

    private int depthOf(TreeNode root) {
        if (root == null) return 0;
        return Math.max(depthOf(root.left), depthOf(root.right)) + 1;
    }


    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(depthOf(root.right) - depthOf(root.left)) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
}