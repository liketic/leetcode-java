package LinkedListCycle;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}


public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode ptr1 = head, ptr2 = head;

        while (ptr2 != null) {
            ptr2 = ptr2.next;
            if (ptr2 != null) {
                ptr2 = ptr2.next;
            }
            ptr1 = ptr1.next;
            if (ptr1 == ptr2) return ptr1 != null;
        }
        return false;
    }
}