package SumRoottoLeafNumbers;

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
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path
 * could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * For example,
 * <p>
 * 1
 * / \
 * 2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 */
class Solution {

    private int sumNumbersFromRoot(TreeNode root, int sum) {
        if (root == null)
            return 0;
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null)
            return sum;
        return sumNumbersFromRoot(root.left, sum) + sumNumbersFromRoot(root.right, sum);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbersFromRoot(root, 0);
    }
}