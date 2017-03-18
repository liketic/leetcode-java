package SwapNodesinPairs;


/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only
 * nodes itself can be changed.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode ptr = head;
        boolean isHead = true;
        ListNode prev = null;

        while (ptr != null && ptr.next != null) {
            ListNode nextOfNext = ptr.next.next;

            ListNode temp = ptr.next;
            ptr.next.next = ptr;
            ptr.next = nextOfNext;

            if (prev != null) {
                prev.next = temp;
            }
            prev = ptr;
            ptr = nextOfNext;

            if (isHead) {
                head = temp;
                isHead = false;
            }
        }

        return head;
    }
}