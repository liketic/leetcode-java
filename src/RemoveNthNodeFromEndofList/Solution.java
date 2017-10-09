package RemoveNthNodeFromEndofList;


/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public int getListLength(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }
        return n;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int offset = getListLength(head);

        if (n == offset) {
            // Delete the head node
            head = head.next;
            return head;
        }

        ListNode ptr = head;

        while (offset > n + 1) {
            ptr = ptr.next;
            offset--;
        }

        ptr.next = ptr.next.next;

        return head;
    }
}