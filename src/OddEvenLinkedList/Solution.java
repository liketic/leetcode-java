package OddEvenLinkedList;


/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 * <p>
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * <p>
 * <pre>
 * Example:
 * Given 1->2->3->4->5->NULL,
 * return 1->3->5->2->4->NULL.
 *
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 * </pre>
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {

    public ListNode oddEvenList(ListNode head) {
        ListNode even = null, odd = null, h = null, s = null;
        boolean isEven = false;

        while (head != null) {
            if (isEven) {
                if (even == null) {
                    h = even = head;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    s = odd = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            isEven = !isEven;
            head = head.next;
        }
        if (odd != null) {
            odd.next = h;
        }
        if (even != null) {
            even.next = null;
        }
        return s;
    }
}
