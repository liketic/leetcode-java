package EliminationGame;


/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first
 * number and every other number afterward until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left, remove the right most number
 * and every other number from the remaining numbers.
 *
 * We keep repeating the steps again, alternating left to right and right to left, until a single
 * number remains.
 *
 * Find the last number that remains starting with a list of length n.
 *
 * Example:
 *
 * <pre>
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 * </pre>
 */
public class Solution {


    public int lastRemaining(int n) {
        int[] ops = new int[64];
        int k = 0;
        boolean isLeft = true;

        while (n > 1) {
            if (n % 2 == 0 && !isLeft) {
                ops[k] = 0;
                k++;
            }
            n >>= 1;
            ops[k] = 1;
            k++;
            isLeft = !isLeft;
        }

        for (int i = k - 1; i >= 0; i--) {
            if (ops[i] == 1) {
                n <<= 1;
            } else {
                n--;
            }
        }
        return n;
    }

}