package TopKFrequentElements;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 */
class Solution {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            queue.add(entry);
            if (queue.size() > k)
                queue.poll();
        }
        List<Integer> topK = new ArrayList<>(k);
        while (!queue.isEmpty())
            topK.add(queue.poll().getKey());
        return topK;
    }
}