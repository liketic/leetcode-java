package MaximumWidthofBinaryTree;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private boolean hasChild(TreeNode node) {
        return node != null && (node.left != null || node.right != null);
    }

    private TreeNode[] resize(TreeNode[] oldNodes, int l, int r) {
        int newSize = (r - l + 1) * 2;
        TreeNode[] table = new TreeNode[newSize];
        // The leftest node's left child and the rightest node's right child might null.
        // But we don't need to handle it here.
        for (int i = l; i <= r; i++) {
            if (oldNodes[i] != null) {
                int j = (i - l) << 1;
                table[j] = oldNodes[i].left;
                table[j + 1] = oldNodes[i].right;
            } // else be null
        }
        return table;
    }

    public int widthOfBinaryTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[]{root};
        int width = 0;
        int l, r;

        for (; ; ) {
            TreeNode[] table = nodes;
            int n = table.length;

            l = 0;
            while (l < n && table[l] == null)
                l++;
            r = n - 1;
            while (r >= 0 && table[r] == null)
                r--;

            if (width < (r - l + 1))
                width = r - l + 1;

            while (l < n && !hasChild(table[l]))
                l++;
            while (r >= 0 && !hasChild(table[r]))
                r--;

            if (r < l || (nodes = resize(table, l, r)) == null)
                break;
        }
        return width;
    }
}