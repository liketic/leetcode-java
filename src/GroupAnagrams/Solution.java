package GroupAnagrams;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {

    private String sorted(String str) {
        char[] asChars = str.toCharArray();
        Arrays.sort(asChars);
        return new String(asChars);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            String key = sorted(str);
            List<String> anagrams = groups.computeIfAbsent(key, v -> new ArrayList<>());
            anagrams.add(str);
        }
        return groups.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }
}