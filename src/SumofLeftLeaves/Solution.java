package SumofLeftLeaves;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 * <pre>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * </pre>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
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

    private int sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }
        return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return sumOfLeftLeaves(root, false);
    }
}