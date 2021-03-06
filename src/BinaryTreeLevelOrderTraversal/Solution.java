package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

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

    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        TreeNode[] table = new TreeNode[]{root};
        int n = 1;

        while (n > 0) {
            List<Integer> values = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                values.add(table[i].val);
            }
            result.add(values);

            int k = 0;
            TreeNode[] next = new TreeNode[n * 2];
            for (int i = 0; i < n; i++) {
                if (table[i].left != null)
                    next[k++] = table[i].left;
                if (table[i].right != null)
                    next[k++] = table[i].right;
            }
            n = k;
            table = next;
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderTraversal(root);
    }
}