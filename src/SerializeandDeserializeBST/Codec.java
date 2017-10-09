package SerializeandDeserializeBST;


import java.util.ArrayList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on
 * how your serialization/deserialization algorithm should work. You just need to ensure that a
 * binary search tree can be serialized to a string and this string can be deserialized to the
 * original tree structure.
 *
 * The encoded string should be as compact as possible.
 *
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

    private String join(List<Integer> nums) {
        StringBuilder builder = new StringBuilder(nums.size() * 2 - 1);
        for (Integer n : nums) {
            if (builder.length() > 0) {
                builder.append(',');
            }
            builder.append(n);
        }
        return builder.toString();
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return null;

        List<Integer> asPreOrder = new ArrayList<>();
        preOrder(root, asPreOrder);
        List<Integer> asInOrder = new ArrayList<>();
        inOrder(root, asInOrder);

        return join(asPreOrder) + "#" + join(asInOrder);
    }

    private TreeNode buildBST(String[] asPreOrder, int s1, int e1, String[] asInOrder, int s2, int e2) {
        if (e1 - s1 != e2 - s2 || e1 >= asPreOrder.length || s1 < 0 || e2 >= asInOrder.length || s2 < 0) {
            // Invalid
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

        node.left = buildBST(asPreOrder, s1 + 1, s1 + n, asInOrder, s2, s2 + n - 1);
        node.right = buildBST(asPreOrder, s1 + n + 1, e1, asInOrder, s2 + n + 1, e2);
        
        return node;
    }

    private TreeNode buildBSTFromArray(String[] asPreOrder, String[] asInOrder) {
        return buildBST(asPreOrder, 0, asPreOrder.length - 1, asInOrder, 0, asInOrder.length - 1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] parts = data.split("#");
        if (parts.length != 2) {
            // Invalid
            return null;
        }
        String[] asPreOrder = parts[0].split(",");
        String[] asInOrder = parts[1].split(",");

        return buildBSTFromArray(asPreOrder, asInOrder);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));