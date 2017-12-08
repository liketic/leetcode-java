package KthSmallestElementinaBST;

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
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 */
class Solution {

    private int countNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private TreeNode kthSmallestNode(TreeNode root, int k) {
        int n = countNodes(root.left);
        if (n >= k)
            return kthSmallestNode(root.left, k);
        else if (n == k - 1)
            return root;
        else
            return kthSmallestNode(root.right, k - n - 1);
    }

    public int kthSmallest(TreeNode root, int k) {
        TreeNode kth = kthSmallestNode(root, k);
        return kth.val;
    }
}