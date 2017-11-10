package TopKFrequentWords;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {


    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o2.getKey().compareTo(o1.getKey());
            return o1.getValue() - o2.getValue();
        });
        wordsCount.entrySet().forEach(e -> {
            queue.add(e);
            if (queue.size() > k) {
                queue.remove();
            }
        });
        List<String> topK = new ArrayList<>(k);
        while (!queue.isEmpty()) {
            // Must in poll order 
            topK.add(queue.poll().getKey());
        }
        Collections.reverse(topK);
        return topK;
    }
}