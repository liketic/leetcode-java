package AddTwoNumbers;


/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are
 * stored in reverse order and each of their nodes contain a single digit. Add the two numbers and
 * return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */

class Solution {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode head = l1;

        while (l2 != null) {
            l1.val += l2.val;
            if (l1.next == null) {
                l1.next = l2.next;
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode ptr = head;
        int temp = 0;

        while (ptr != null) {
            ptr.val += temp;
            temp = ptr.val / 10;
            ptr.val %= 10;

            if (ptr.next == null && temp > 0) {
                ptr.next = new ListNode(temp);
                break;
            }
            ptr = ptr.next;
        }

        return head;
    }

}