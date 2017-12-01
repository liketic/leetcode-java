package EqualTreePartition;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int sumVal(TreeNode root) {
        if (root == null)
            return 0;
        return sumVal(root.left) + sumVal(root.right) + root.val;
    }

    private boolean checkSum(TreeNode root, int v) {
        if (root == null)
            return false;
        int t = sumVal(root);
        if (t == v)
            return true;
        return checkSum(root.left, v) || checkSum(root.right, v);
    }

    public boolean checkEqualTree(TreeNode root) {
        int sumVal = sumVal(root);
        if (sumVal % 2 != 0)
            return false;
        sumVal /= 2;
        return checkSum(root.left, sumVal) || checkSum(root.right, sumVal);
    }
}