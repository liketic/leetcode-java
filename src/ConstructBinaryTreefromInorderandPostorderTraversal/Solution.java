package ConstructBinaryTreefromInorderandPostorderTraversal;

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

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 */
class Solution {
    private TreeNode buildTree(int[] inorder, int l, int r,
                               int[] postorder, int s, int e) {
        if (l > r)
            return null;
        TreeNode root = new TreeNode(postorder[e]);
        int i = l;
        while (i <= r && inorder[i] != postorder[e])
            i++;
        root.left = buildTree(inorder, l, i - 1, postorder, s, s + i - l - 1);
        root.right = buildTree(inorder, i + 1, r, postorder, s + i - l, e - 1);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
}