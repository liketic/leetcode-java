package RemoveDuplicatesfromSortedListII;

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
 * Given a sorted linked list, delete all nodes that have duplicate
 * numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 */
class Solution {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode nh = null, ptr = null;

        while (head != null) {
            int val = head.val, count = 0;
            ListNode node = head;

            while (node != null && node.val == val) {
                count++;
                node = node.next;
            }
            if (count == 1) {
                if (nh == null) {
                    nh = ptr = head;
                } else {
                    ptr.next = head;
                    ptr = ptr.next;
                }
                ptr.next = null;
            }
            head = node;
        }
        return nh;
    }
}