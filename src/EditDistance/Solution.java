package EditDistance;


class Solution {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null)
            return 0;
    
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 == 0)
            return len2;
        if (len2 == 0)
            return len1;
        int[][] max = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0)
                    max[i][j] = j;
                else if (j == 0)
                    max[i][j] = i;
                else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        max[i][j] = max[i - 1][j - 1];
                    } else {
                        max[i][j] = Math.min(max[i - 1][j - 1],
                                Math.min(max[i - 1][j], max[i][j - 1])) + 1;
                    }
                }
            }
        }
        return max[len1][len2];
    }
}