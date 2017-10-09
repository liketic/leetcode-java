package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program that outputs the string representation of numbers from 1 to n.
 *
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of
 * five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 *
 * Example:
 * <pre>
 * n = 15,
 *
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 * </pre>
 */
class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> fizz = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fizz.add("FizzBuzz");
            } else if (i % 3 == 0) {
                fizz.add("Fizz");
            } else if (i % 5 == 0) {
                fizz.add("Buzz");
            } else {
                fizz.add("" + i);
            }
        }
        return fizz;
    }
}