package SortList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {


    private static ListNode mergeInOrder(ListNode lhr, ListNode rhr) {
        if (lhr == null) return rhr;
        if (rhr == null) return lhr;
        ListNode r = null, h = null;
        while (lhr != null && rhr != null) {
            ListNode v;
            if (lhr.val < rhr.val) {
                v = lhr;
                lhr = lhr.next;
            } else {
                v = rhr;
                rhr = rhr.next;
            }
            if (r == null) {
                h = r = v;
            } else {
                r.next = v;
                r = r.next;
            }
        }
        if (lhr != null) r.next = lhr;
        else {
            r.next = rhr;
        }
        return h;
    }

    public ListNode sortList(ListNode head) {
        // No more than one element
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode next = slow.next;
        slow.next = null;

        return mergeInOrder(sortList(next), sortList(head));
    }
}