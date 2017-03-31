package CountandSay;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {

    public String countAndSay(int n) {
        String str = "1";
        StringBuilder builder = new StringBuilder();

        while (n > 1) {
            n--;
            int len = str.length();
            int count = 1, pos = 0;

            // reset builder
            builder.setLength(0);

            for (int i = 1; i < len; i++) {
                if (str.charAt(i) != str.charAt(pos)) {
                    builder.append(count);
                    builder.append(str.charAt(pos));
                    pos = i;
                    count = 1;
                } else {
                    count++;
                }
            }
            builder.append(count);
            builder.append(str.charAt(pos));
            str = builder.toString();
        }

        return str;
    }
}