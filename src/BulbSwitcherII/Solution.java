package BulbSwitcherII;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private void flip(int[] flag, int n, int k) {
        switch (k) {
            case 0:
                // Flip all the lights
                for (int i = 1; i <= n; i++) {
                    flag[i] = flag[i] == 1 ? 0 : 1;
                }
                break;
            case 1:
                //Flip lights with odd numbers.
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 1) {
                        flag[i] = flag[i] == 1 ? 0 : 1;
                    }
                }
                break;
            case 2:
                // Flip lights with even numbers.
                for (int i = 1; i <= n; i++) {
                    if (i % 2 == 0) {
                        flag[i] = flag[i] == 1 ? 0 : 1;
                    }
                }
                break;
            case 3:
                //Flip lights with (3k + 1) numbers, k = 0, 1, 2, ...
                for (int i = 1; i <= n; i++) {
                    if (i % 3 == 1) {
                        flag[i] = flag[i] == 1 ? 0 : 1;
                    }
                }
                break;
        }
    }

    private boolean equalsTo(String s, int[] f, int n) {
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if ((c - '0') != f[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public int flipLights(int n, int m) {
        if (m == 0) return 1;
        if (m > 4) m = 4;

        int[] flag = new int[n + 1];
        List<String> r = new ArrayList<>();

        for (int i = 0; i < (1 << 4); i++) {
            int s = 0;
            for (int j = 0; j < 4; j++) {
                if ((i & (1 << j)) > 0) {
                    s++;
                }
            }
            if (m < s || (m - s) % 2 != 0) {
                // Could not reach status i
                continue;
            }

            for (int j = 1; j <= n; j++)
                flag[j] = 0;

            for (int j = 0; j < 4; j++) {
                if ((i & (1 << j)) > 0) {
                    flip(flag, n, j);
                }
            }

            boolean f = true;

            for (int j = r.size() - 1; j >= 0; j--) {
                String x = r.get(j);
                if (equalsTo(x, flag, n)) {
                    f = false;
                    break;
                }
            }
            if (f) {
                StringBuilder builder = new StringBuilder(n);
                for (int k = 1; k <= n; k++) {
                    builder.append(flag[k]);
                }
                r.add(builder.toString());
            }
        }

        return r.size();
    }
}