package DeleteNodeinaBST;


/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove. If the node is found, delete the node. Note: Time complexity should
 * be O(height of tree).
 *
 * Example:
 * <pre>
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *
 * 5
 * / \
 * 3   6
 * / \   \
 * 2   4   7
 * </pre>
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 *
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 * <pre>
 * 5
 * / \
 * 4   6
 * /     \
 * 2       7
 * </pre>
 * Another valid answer is [5,2,6,null,4,null,7].
 * <pre>
 * 5
 * / \
 * 2   6
 * \   \
 * 4   7
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

    private void replace(TreeNode parent, TreeNode node, TreeNode newNode) {
        if (parent.left == node) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    private TreeNode deleteOneNode(TreeNode root, TreeNode p, TreeNode node) {
        if (node.left == null || node.right == null) {
            TreeNode n = node.left == null ? node.right : node.left;
            if (node == root) return n;
            replace(p, node, n);
        } else {
            TreeNode np = node;
            TreeNode n = node.left;
            while (n.right != null) {
                np = n;
                n = n.right;
            }
            if (np == node) {
                n.right = node.right;
                if (p != null) {
                    replace(p, node, n);
                } else {
                    root = n;
                }
            } else {
                np.right = n.left;
                n.left = node.left;
                n.right = node.right;
                if (p != null) {
                    replace(p, node, n);
                } else {
                    root = n;
                }
            }
        }
        return root;
    }

    private TreeNode deleteNode(TreeNode root, TreeNode p, TreeNode node, int key) {
        if (node == null) {
            return root;
        }
        if (node.val == key) {
            return deleteOneNode(root, p, node);
        } else if (node.val > key) {
            return deleteNode(root, node, node.left, key);
        } else {
            return deleteNode(root, node, node.right, key);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        return deleteNode(root, null, root, key);
    }
}