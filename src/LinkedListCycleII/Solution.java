package LinkedListCycleII;


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {

    private boolean isOnCycle(ListNode node, ListNode cycle) {
        ListNode backup = cycle;
        while (cycle != node) {
            cycle = cycle.next;
            if (cycle == backup) {
                break;
            }
        }
        return cycle == node;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode ptr1 = head, ptr2 = head;

        while (ptr2 != null) {
            ptr2 = ptr2.next;
            if (ptr2 == null) return null;
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
            if (ptr1 == ptr2) break;
        }

        if (ptr2 == null) return null;

        // Solution 1: check all nodes from head
//        ptr1 = head;
//        while (ptr1 != null) {
//            if (isOnCycle(ptr1, ptr2)) return ptr1;
//            ptr1 = ptr1.next;
//        }
//        return null;

        // Solution 2: http://blog.csdn.net/wuzhekai1985/article/details/6725263
        ptr1 = head;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}