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

public class Solution {


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


    private static void printListNode(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" > ");
            }
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = new Solution().addTwoNumbers(l2, l1);
        printListNode(node);
    }

}