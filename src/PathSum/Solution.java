package PathSum;


/**
 * Given a binary tree and a sum, determine if the tree has a
 * root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * For example: Given the below binary tree and sum = 22,
 * <pre>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * </pre>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null) {
            return sum == root.val;
        } else {
            sum -= root.val;
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }
}