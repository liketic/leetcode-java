package MinimumDepthofBinaryTree;


/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if (root.left != null) {
            depth = Math.min(depth, minDepth(root.left));
        }
        if (root.right != null) {
            depth = Math.min(depth, minDepth(root.right));
        }
        return depth + 1;
    }
}