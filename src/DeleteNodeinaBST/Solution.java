package DeleteNodeinaBST;


/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove. If the node is found, delete the node. Note: Time complexity should
 * be O(height of tree).
 * <p>
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
 * <p>
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

class Solution {

    private TreeNode fixup(TreeNode root, TreeNode parent, TreeNode toRemove, TreeNode newNode) {
        if (parent == null)
            return newNode;
        if (parent.left == toRemove)
            parent.left = newNode;
        else
            parent.right = newNode;
        return root;
    }

    private TreeNode deleteNode(TreeNode root, TreeNode parent, TreeNode node) {
        if (node.left == null) {
            return fixup(root, parent, node, node.right);
        } else if (node.right == null) {
            return fixup(root, parent, node, node.left);
        } else {
            // Both node.left and node.right are not null
            TreeNode maxOfLeft = node.left;
            TreeNode ptr = node;
            // Find the rightest node in left child tree and its parent
            while (maxOfLeft.right != null) {
                ptr = maxOfLeft;
                maxOfLeft = maxOfLeft.right;
            }
            if (ptr == node) {
                // The max node is the left child of node which means its left 
                // child node has no right child node.
                maxOfLeft.right = node.right;
            } else {
                ptr.right = maxOfLeft.left;
                maxOfLeft.left = node.left;
                maxOfLeft.right = node.right;
            }
            return fixup(root, parent, node, maxOfLeft);
        }
    }

    private TreeNode deleteNode(TreeNode root, TreeNode parent, TreeNode node, int key) {
        if (node == null) {
            return root;
        } else if (node.val == key) {
            return deleteNode(root, parent, node);
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