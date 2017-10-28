package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 * <p>
 * <p>
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
        List<List<Integer>> valuesByLevel = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            valuesByLevel.add(valList);
        }
        return valuesByLevel;
    }

    private List<List<Integer>> levelOrderWithoutQueue(TreeNode root) {
        List<List<Integer>> valuesByLevel = new ArrayList<>();
        int size = 1;

        TreeNode[] nodes = new TreeNode[1];
        nodes[0] = root;

        while (true) {
            List<Integer> valList = new ArrayList<>();

            TreeNode[] newNodes = new TreeNode[size * 2];
            int k = 0;
            for (int i = 0; i < size; i++) {
                valList.add(nodes[i].val);
                if (nodes[i].left != null) {
                    newNodes[k++] = nodes[i].left;
                }
                if (nodes[i].right != null) {
                    newNodes[k++] = nodes[i].right;
                }
            }
            valuesByLevel.add(valList);
            if (k == 0) break;
            size = k;
            nodes = newNodes;
        }
        return valuesByLevel;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
//        return levelOrderWithQueue(root);
        return levelOrderWithoutQueue(root);
    }
}