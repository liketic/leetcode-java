package MergekSortedLists;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        ListNode h = null, ptr = null;
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        Arrays.stream(lists).forEach(l -> {
            if (l != null)
                queue.add(l);
        });

        while (!queue.isEmpty()) {
            ListNode minNode = queue.poll();
            ListNode next = minNode.next;
            if (h == null)
                h = ptr = minNode;
            else {
                ptr.next = minNode;
                ptr = ptr.next;
            }
            if (next != null)
                queue.add(next);
        }
        return h;
    }
}