package RotateList;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 *
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    private int sizeOf(ListNode head) {
        ListNode ptr = head;
        int n = 0;
        while (ptr != null) {
            n++;
            ptr = ptr.next;
        }
        return n;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int n = sizeOf(head);

        if (n == 0) return head;
        k %= n;
        if (k == 0) return head;

        ListNode ptr = head;
        for (int i = 0; i < n - k - 1; i++) {
            ptr = ptr.next;
        }

        ListNode node = ptr.next;
        ListNode newHead = node;
        ptr.next = null;

        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return newHead;
    }
}
