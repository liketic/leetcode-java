package MaximumWidthofBinaryTree;


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        TreeNode[] arr = new TreeNode[]{root};
        int s = 1;

        while (true) {
            TreeNode[] t = arr;
            int c = 0;
            boolean leftNull = true;
            int k;
            boolean con = false;

            for (int i = 0; i < t.length; i++) {
                TreeNode node = t[i];
                c++;
                if (node != null) {
                    if (leftNull) {
                        leftNull = false;
                        c = 1;
                    }
                    s = Math.max(s, c);
                    if (node.left != null || node.right != null) {
                        con = true;
                    }
                }
            }
            if (!con) break;

            int l = t.length, r = -1;

            for (int i = 0; i < t.length; i++) {
                TreeNode node = t[i];
                if (node != null) {
                    if (l == t.length) l = i;
                    r = i;
                }
            }
            arr = new TreeNode[(r - l + 1) * 2];
            k = 0;
            for (int i = l; i <= r; i++) {
                if (t[i] != null) {
                    arr[k++] = t[i].left;
                    arr[k++] = t[i].right;
                } else {
                    arr[k++] = null;
                    arr[k++] = null;
                }
            }
        }
        return s;
    }
}