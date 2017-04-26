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

public class Solution {
    

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> vals = new ArrayList<>();

        if (root == null) return vals;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // A flag for direction
        boolean fromLeft = true;

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
            if (!fromLeft) {
                Collections.reverse(valsOnCurrentLevel);
            }
            fromLeft = !fromLeft;
            vals.add(valsOnCurrentLevel);
        }
        return vals;
    }
}