package SentenceSimilarity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    private boolean isSimilar(String word1, String word2, Map<String, List<String>> similarMap) {
        if (word1.equals(word2))
            return true;
        List<String> similarTo = similarMap.get(word1);
        if (similarTo != null && similarTo.contains(word2))
            return true;
        similarTo = similarMap.get(word2);
        return similarTo != null && similarTo.contains(word1);
    }

    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length)
            return false;
        Map<String, List<String>> similarMap = new HashMap<>();

        for (String[] pair : pairs) {
            if (pair.length != 2)
                return false;
            List<String> similar = similarMap.getOrDefault(pair[0], new ArrayList<>());
            if (!similar.contains(pair[1])) {
                similar.add(pair[1]);
            }
            similarMap.put(pair[0], similar);
        }

        for (int i = 0; i < words1.length; i++) {
            if (!isSimilar(words1[i], words2[i], similarMap))
                return false;
        }
        return true;
    }
}