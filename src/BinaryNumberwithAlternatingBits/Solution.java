package BinaryNumberwithAlternatingBits;


class Solution {

    public boolean hasAlternatingBits(int n) {
        boolean flag = (n % 2) == 1;
        while (n > 0) {
            n >>= 1;
            if (((n & 1) == 1) == flag)
                return false;
            flag = !flag;
        }
        return true;
    }
}