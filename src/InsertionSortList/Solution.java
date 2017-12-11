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
                ListNode next = head.next;
                head.next = nh;
                nh = head;
                head = next;
                continue;
            }
            ListNode p = nh;
            boolean inserted = false;
            while (p.next != null) {
                if (head.val < p.next.val) {
                    ListNode next = head.next;
                    ListNode pnext = p.next;
                    p.next = head;
                    head.next = pnext;
                    head = next;
                    inserted = true;
                    break;
                }
                p = p.next;
            }
            if (!inserted) {
                p.next = head;
                head = head.next;
                p.next.next = null;
            }
        }
        return nh;
    }
}