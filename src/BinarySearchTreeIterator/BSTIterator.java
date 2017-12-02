package BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Definition for binary tree
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


public class BSTIterator {

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        populate(root);
    }

    private void populate(TreeNode root) {
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode topNode = stack.pop();
        populate(topNode.right);
        return topNode.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */