package BinaryTreeLevelOrderTraversalII;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> order = levelOrderTraversal(root);
        Collections.reverse(order);
        return order;
    }
}