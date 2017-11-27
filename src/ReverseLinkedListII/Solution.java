package ReverseLinkedListII;


/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * <p>
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * <p>
 * return 1->4->3->2->5->NULL.
 * <p>
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 */
class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n - 1)
            return head;

        ListNode mthPrev = null;

        // Find the node before m-th node
        for (int i = m; i > 1; i--) {
            mthPrev = i == m ? head : mthPrev.next;
        }

        // Find the node after n-th node
        ListNode nthNext = head;
        for (int i = n; i > 0; i--) {
            nthNext = nthNext.next;
        }

        // Reverse nodes between m-th and n-th node
        ListNode node = mthPrev == null ? head : mthPrev.next;
        int num = n - m + 1;

        while (num > 0) {
            ListNode next = node.next;
            node.next = nthNext;
            nthNext = node;
            node = next;
            num--;
        }
        if (mthPrev == null)
            return nthNext;

        mthPrev.next = nthNext;
        return head;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}