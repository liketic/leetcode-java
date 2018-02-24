package SerializeandDeserializeBST;


import java.util.ArrayList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that a
 * binary search tree can be serialized to a string and this string can be deserialized to the
 * original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Codec {

    private final static String NODE_SEPARATOR = ",";
    private final static String TREE_SEPARATOR = "#";


    private void preOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        nums.add(root.val);
        preOrder(root.left, nums);
        preOrder(root.right, nums);
    }

    private void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    private String join(List<Integer> nums, String delimiter) {
        // The initial capacity is not correct
        StringBuilder builder = new StringBuilder(nums.size() * 2 - 1);
        for (Integer n : nums) {
            if (builder.length() > 0) {
                builder.append(delimiter);
            }
            builder.append(n);
        }
        return builder.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return null;
        List<Integer> asPreOrder = new ArrayList<>();
        preOrder(root, asPreOrder);
        List<Integer> asInOrder = new ArrayList<>();
        inOrder(root, asInOrder);
        return join(asPreOrder, NODE_SEPARATOR) + TREE_SEPARATOR + join(asInOrder, NODE_SEPARATOR);
    }

    private boolean checkRange(int s1, int e1, int max1, int s2, int e2, int max2) {
        return (s1 >= 0 && s1 <= e1 && e1 < max1 && s2 >= 0 && s2 <= e2 && e2 < max2 && e1 - s1 == e2 - s2);
    }

    private TreeNode buildTree(String[] asPreOrder, int s1, int e1, String[] asInOrder, int s2, int e2) {
        if (!checkRange(s1, e1, asPreOrder.length, s2, e2, asInOrder.length)) {
            return null;
        }
        String root = asPreOrder[s1];
        int i = s2;
        for (; i <= e2; i++) {
            if (root.equals(asInOrder[i])) {
                break;
            }
        }
        if (i > e2) return null;
        TreeNode node = new TreeNode(Integer.parseInt(root));
        int n = i - s2;

        node.left = buildTree(asPreOrder, s1 + 1, s1 + n, asInOrder, s2, s2 + n - 1);
        node.right = buildTree(asPreOrder, s1 + n + 1, e1, asInOrder, s2 + n + 1, e2);

        return node;
    }

    private TreeNode buildTreeFromTraverseOrder(String[] asPreOrder, String[] asInOrder) {
        return buildTree(asPreOrder, 0, asPreOrder.length - 1, asInOrder, 0, asInOrder.length - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null)
            return null;
        String[] trees = data.split(TREE_SEPARATOR);
        if (trees.length != 2) {
            // Invalid
            return null;
        }
        String[] asPreOrder = trees[0].split(NODE_SEPARATOR);
        String[] asInOrder = trees[1].split(NODE_SEPARATOR);
        return buildTreeFromTraverseOrder(asPreOrder, asInOrder);
    }
}

