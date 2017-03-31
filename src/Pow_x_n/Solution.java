package Pow_x_n;

/**
 * Implement pow(x, n).
 */
public class Solution {

    private double powFor(double x, long n) {
        if (n < 0) {
            return 1 / powFor(x, n * -1);
        }
        if (n == 0) return 1.0;
        if (n == 1) return x;
        double half = powFor(x, n / 2);
        if (n % 2 == 1) {
            return half * half * x;
        } else {
            return half * half;
        }
    }

    public double myPow(double x, int n) {
        return powFor(x, (long) n);
    }
}