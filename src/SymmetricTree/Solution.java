package SymmetricTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
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

    private boolean checkSymmetricRecursively(TreeNode l, TreeNode r) {
        if (l == null && r == null) return true;
        if (l == null || r == null) return false;
        if (l.val != r.val) return false;
        return checkSymmetricRecursively(l.left, r.right) && checkSymmetricRecursively(l.right, r.left);
    }

    private boolean isSame(TreeNode l, TreeNode r) {
        return (l == null && r == null) || (l != null && r != null && l.val == r.val);
    }

    private boolean checkSymmetricIteratively(TreeNode root) {
        if (root == null) {
            return true;
        }
        int size = 1;

        List<TreeNode> nodes = new ArrayList<>(size);
        nodes.add(root);

        while (true) {
            for (int i = 0, j = nodes.size() - 1; i < j; i++, j--) {
                if (!isSame(nodes.get(i), nodes.get(j))) {
                    return false;
                }
            }
            size *= 2;
            List<TreeNode> newNodes = new ArrayList<>(size);

            for (TreeNode node : nodes) {
                if (node != null) {
                    newNodes.add(node.left);
                    newNodes.add(node.right);
                }
            }
            if (newNodes.size() == 0)
                return true;
            nodes = newNodes;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
//        return checkSymmetricRecursively(root.left, root.right);
        return checkSymmetricIteratively(root);
    }
    
}