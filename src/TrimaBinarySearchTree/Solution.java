package TrimaBinarySearchTree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private boolean checkRange(int v, int L, int R) {
        return v >= L && v <= R;
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        while (!checkRange(root.val, L, R)) {
            if (root.val < L) {
                root = root.right;
            } else if (root.val > R) {
                root = root.left;
            }
            if (root == null) return null;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}