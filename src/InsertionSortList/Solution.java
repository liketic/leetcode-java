package InsertionSortList;

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
 * Sort a linked list using insertion sort.
 */
class Solution {

    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode nh = head;
        head = head.next;
        nh.next = null;

        while (head != null) {
            if (head.val < nh.val) {
                // Insert before the head node
                ListNode next = head.next;
                head.next = nh;
                nh = head;
                head = next;
                continue;
            }
            ListNode p = nh;
            while (true) {
                if (p.next == null) {
                    // Insert after the tail node
                    p.next = head;
                    head = head.next;
                    p.next.next = null;
                    break;
                }
                if (head.val < p.next.val) {
                    // Insert in the middle of list 
                    ListNode next = head.next;
                    ListNode pnext = p.next;
                    p.next = head;
                    head.next = pnext;
                    head = next;
                    break;
                }
                p = p.next;
            }
        }
        return nh;
    }
}