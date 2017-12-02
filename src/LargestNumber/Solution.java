package LargestNumber;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * <p>
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
class Solution {

    public String largestNumber(int[] nums) {
        List<Integer> asList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        asList.sort((o1, o2) -> {
            final String s1 = o1.toString();
            final String s2 = o2.toString();
            return (s2 + s1).compareTo(s1 + s2);
        });
        int i = 0, n = asList.size();
        while (i < n && asList.get(i) == 0)
            i++;
        if (i == n)
            return "0";
        StringBuilder builder = new StringBuilder();
        for (; i < n; i++)
            builder.append(asList.get(i));
        return builder.toString();
    }
}