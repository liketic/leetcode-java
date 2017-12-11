package ConstructBinaryTreefromPreorderandInorderTraversal;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
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

    private TreeNode buildTree(int[] preorder, int l, int r,
                               int[] inorder, int s, int e) {
        if (l > r)
            return null;
        TreeNode root = new TreeNode(preorder[l]);
        int i = s;
        while (i <= e && inorder[i] != preorder[l])
            i++;
        root.left = buildTree(preorder, l + 1, l + i - s, inorder, s, i - 1);
        root.right = buildTree(preorder, l + i - s + 1, r, inorder, i + 1, e);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
}