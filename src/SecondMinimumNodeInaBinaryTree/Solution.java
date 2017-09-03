package SecondMinimumNodeInaBinaryTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


class Solution {

    private int findMaximumValueLessThan(TreeNode root, int val) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.val != val)
            return root.val;
        return Math.min(findMaximumValueLessThan(root.left, val),
                findMaximumValueLessThan(root.right, val));
    }

    public int findSecondMinimumValue(TreeNode root) {
        int x = root.val;
        int v = findMaximumValueLessThan(root, x);
        return v == Integer.MAX_VALUE ? -1 : v;
    }
}