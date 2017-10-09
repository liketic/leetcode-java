package ZigZagConversion;


class Solution {

    public String convert(String s, int numRows) {
        if (s == null || numRows == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder(s.length());

        int offset = (numRows * 2 - 2);
        int n = s.length();

        for (int i = numRows; i >= 1; i--) {
            int next = i * 2 - 2;
            for (int j = numRows - i; j < n; j += offset) {
                builder.append(s.charAt(j));
                if (i > 1 && i < numRows && j + next < n) {
                    builder.append(s.charAt(j + next));
                }
            }
        }

        return builder.toString();
    }
}