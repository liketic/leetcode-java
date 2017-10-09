package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 *
 * For example: Given binary tree [3,9,20,null,null,15,7],
 * <pre>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * </pre>
 * return its zigzag level order traversal as:
 * <pre>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * </pre>
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

    private List<List<Integer>> levelOrderWithQueue(TreeNode root) {
        List<List<Integer>> vals = new ArrayList<>();

        if (root == null) return vals;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> valsOnCurrentLevel = new ArrayList<>();

            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                valsOnCurrentLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            vals.add(valsOnCurrentLevel);
        }
        return vals;
    }

    private List<List<Integer>> levelOrderWithoutQueue(TreeNode root) {
        List<List<Integer>> vals = new ArrayList<>();

        if (root == null) return vals;
        int size = 1;

        TreeNode[] nodes = new TreeNode[1];
        nodes[0] = root;

        while (true) {
            List<Integer> valsOnCurrentLevel = new ArrayList<>();

            TreeNode[] newNodes = new TreeNode[size * 2];
            int k = 0;

            for (int i = 0; i < size; i++) {
                valsOnCurrentLevel.add(nodes[i].val);
                if (nodes[i].left != null) {
                    newNodes[k++] = nodes[i].left;
                }
                if (nodes[i].right != null) {
                    newNodes[k++] = nodes[i].right;
                }
            }
            vals.add(valsOnCurrentLevel);
            if (k == 0) break;
            size = k;
            nodes = newNodes;
        }
        return vals;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
//        return levelOrderWithQueue(root);
        return levelOrderWithoutQueue(root);
    }
}