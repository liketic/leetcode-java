package SerializeandDeserializeBinaryTree;

import java.util.Stack;

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

/**
 * The difference between binary tree and binary search tree is BST must
 * not contains duplicate values.
 */
class Codec {

    private final static String NODE_SEPARATOR = ",";
    private final static String NULL_PLACEHOLDER = "-";


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            TreeNode top = stack.peek();
            if (builder.length() > 0) {
                builder.append(NODE_SEPARATOR);
            }
            if (top == null) {
                builder.append(NULL_PLACEHOLDER);
                stack.pop();
                if (!stack.isEmpty()) {
                    top = stack.pop();
                    stack.push(top.right);
                }
            } else {
                builder.append(top.val);
                stack.push(top.left);
            }
        }
        return builder.toString();
    }

    private TreeNode deserializeNode(String s) {
        if (s.equals(NULL_PLACEHOLDER))
            return null;
        return new TreeNode(Integer.parseInt(s));
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] nodes = data.split(NODE_SEPARATOR);
        if (nodes.length == 0) {
            return null;
        }
        TreeNode root = deserializeNode(nodes[0]);
        if (nodes.length == 1)
            return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int i = 1;
        while (!stack.isEmpty() && i < nodes.length) {
            TreeNode top = stack.peek();
            top.left = deserializeNode(nodes[i++]);
            if (top.left != null) {
                stack.push(top.left);
                continue;
            }
            top.right = deserializeNode(nodes[i++]);
            if (top.right != null) {
                // Remove the top node because its both child has been accessed
                stack.pop();
                stack.push(top.right);
                continue;
            }
            stack.pop();
            // Find the highest node which right child is not null
            while (!stack.isEmpty()) {
                top = stack.pop();
                top.right = deserializeNode(nodes[i++]);
                if (top.right != null) {
                    stack.push(top.right);
                    break;
                }
            }
        }
        return root;
    }
}

