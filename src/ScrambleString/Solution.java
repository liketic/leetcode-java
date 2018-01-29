package ScrambleString;


class Solution {

    private int[][][][] cache;

    private boolean check(String s1, String s2, int l1, int r1, int l2, int r2) {
        if (cache[l1][r1][l2][r2] != 0) {
            return cache[l1][r1][l2][r2] == 1;
        }
        int f = -1;
        if (l1 == r1) {
            if (s1.charAt(l1) == s2.charAt(l2)) {
                f = 1;
            }
        } else {
            for (int i = l1, j = l2; i < r1 && j < r2; i++, j++) {
                int n = i - l1 + 1;
                if (check(s1, s2, l1, i, l2, j) && check(s1, s2, i + 1, r1, j + 1, r2)) {
                    f = 1;
                    break;
                } else if (check(s1, s2, l1, i, r2 - n + 1, r2)
                        && check(s1, s2, i + 1, r1, l2, r2 - n)) {
                    f = 1;
                    break;
                }
            }
        }
        cache[l1][r1][l2][r2] = f;
        return f == 1;
    }

    public boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null)
            return true;
        if (s1 == null || s2 == null)
            return false;
        if (s1.equals(s2))
            return true;
        int len = s1.length();
        if (s2.length() != len)
            return false;
        if (len == 0)
            return true;
        cache = new int[len][len][len][len];
        return check(s1, s2, 0, len - 1, 0, len - 1);
    }
}