package StickerstoSpellWord;


class Solution {

    private boolean check(String[] stickers, String target, int i) {
        boolean[] v = new boolean[26];
        for (int j = 0; j < target.length(); j++) {
            v[target.charAt(j) - 'a'] = true;
        }
        for (int j = 0; j < stickers.length; j++) {
            if ((i & (1 << j)) > 0) {
                for (int k = 0; k < stickers[j].length(); k++) {
                    v[stickers[j].charAt(k) - 'a'] = false;
                }
            }
        }
        for (int j = 0; j < 26; j++)
            if (v[j])
                return false;
        return true;
    }

    public int minStickers(String[] stickers, String target) {
        // TODO this solution does not work now
        int r = Integer.MAX_VALUE;
        int n = stickers.length;

        for (int i = 1; i < (1 << n); i++) {
            int c = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    c++;
                }
            }
            if (c >= r)
                continue;
            if (check(stickers, target, i)) {
                r = c;
            }
        }
        return r;
    }

}