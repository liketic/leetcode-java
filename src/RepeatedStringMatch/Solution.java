package RepeatedStringMatch;


class Solution {

    private boolean check(int n, String a, String b) {
        StringBuilder builder = new StringBuilder(a.length() * n);
        for (int i = 0; i < n; i++) {
            builder.append(a);
        }
        return builder.toString().contains(b);
    }

    public int repeatedStringMatch(String A, String B) {
        int l = B.length(), r = A.length();
        int x = 1, y = (l + r - 1) / r + 1;
        int rv = -1;
        while (x <= y) {
            int z = (x + y) / 2;
            if (check(z, A, B)) {
                if (rv == -1) {
                    rv = z;
                } else {
                    rv = Math.min(r, z);
                }
                y = z - 1;
            } else {
                x = z + 1;
            }
        }
        return rv;
    }
}