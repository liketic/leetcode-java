package PartitionList;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes
 * greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * <pre>
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * </pre>
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {


    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode high = null, low = null, hl = null, hh = null;

        do {
            if (head.val < x) {
                if (low == null) {
                    hl = low = head;
                } else {
                    low.next = head;
                    low = low.next;
                }
            } else {
                if (high == null) {
                    hh = high = head;
                } else {
                    high.next = head;
                    high = high.next;
                }
            }
        } while ((head = head.next) != null);

        if (high != null) {
            high.next = null;
        }

        if (low != null) {
            low.next = hh;
            return hl;
        } else {
            return hh;
        }
    }
}