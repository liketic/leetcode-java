package MaximumDepthofBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
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

    private int maxDepthRecursively(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepthRecursively(root.left), maxDepthRecursively(root.right)) + 1;
    }


    private int maxDepthIteratively(TreeNode root) {
        // This Solution is much slower
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int depth = 1;

        while (!queue.isEmpty()) {
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public int maxDepth(TreeNode root) {
//        return maxDepthRecursively(root);
        return maxDepthIteratively(root);
    }
}