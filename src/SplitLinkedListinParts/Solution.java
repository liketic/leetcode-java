package SplitLinkedListinParts;


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

class Solution {

    private int getLength(ListNode root) {
        int s = 0;
        while (root != null) {
            s++;
            root = root.next;
        }
        return s;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        int s = getLength(root);
        int v = s / k, u = s - v * k;

        ListNode[] parts = new ListNode[k];
        int r = 0;

        for (; ; ) {
            parts[r++] = root;
            if (r == k)
                break;
            if (root == null)
                continue;

            int t = v + (u > 0 ? 1 : 0);
            u--;
            for (int j = 0; j < t - 1; j++) {
                if (root == null)
                    break;
                root = root.next;
            }
            if (root == null)
                continue;
            ListNode next = root.next;
            root.next = null;
            root = next;
        }

        return parts;
    }
}