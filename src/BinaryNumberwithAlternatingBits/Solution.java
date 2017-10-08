package BinaryNumberwithAlternatingBits;


class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag = (n % 2) == 1;
        n /= 2;
        while (n > 0) {
            boolean f = (n % 2) == 1;
            if (f == flag)
                return false;
            n /= 2;
            flag = f;
        }
        return true;
    }
}