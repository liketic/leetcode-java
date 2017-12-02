package ConvertSortedListtoBinarySearchTree;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

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
 * Given a singly linked list where elements are sorted in
 * ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined
 * as a binary tree in which the depth of the two subtrees of
 * every node never differ by more than 1.
 */
class Solution {

    private TreeNode buildBST(ListNode head, int length) {
        if (length <= 0)
            return null;
        int half = length >> 1;
        ListNode h = head;
        for (int i = 0; i < half; i++)
            h = h.next;
        TreeNode root = new TreeNode(h.val);
        root.left = buildBST(head, half);
        root.right = buildBST(h.next, length - half - 1);
        return root;
    }

    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode h = head;
        while (h != null) {
            ++n;
            h = h.next;
        }
        return buildBST(head, n);
    }
}