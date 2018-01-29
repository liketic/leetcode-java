package HouseRobberIII;

import java.util.HashMap;
import java.util.Map;

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

    private int rob(TreeNode root, Map<TreeNode, Integer> cache) {
        if (root == null)
            return 0;
        if (cache.containsKey(root))
            return cache.get(root);
        int robbed = 0;
        if (root.left != null) {
            robbed += rob(root.left.left, cache) + rob(root.left.right, cache);
        }
        if (root.right != null) {
            robbed += rob(root.right.left, cache) + rob(root.right.right, cache);
        }
        int r = Math.max(robbed + root.val, rob(root.left, cache) + rob(root.right, cache));
        cache.put(root, r);
        return r;
    }

    public int rob(TreeNode root) {
        Map<TreeNode, Integer> cache = new HashMap<>();
        return rob(root, cache);
    }
}