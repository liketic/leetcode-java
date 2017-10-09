package BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left
 * to right, then right to left for the next level and alternate between).
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
 * [20,9],
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


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> resultSet = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // A flag for direction
        boolean fromLeft = true;

        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> values = new ArrayList<>(num);
            
            for (int i = num - 1; i >= 0; i--) {
                TreeNode node = queue.poll();
                values.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!fromLeft) {
                Collections.reverse(values);
            }
            fromLeft = !fromLeft;
            resultSet.add(values);
        }
        return resultSet;
    }
}