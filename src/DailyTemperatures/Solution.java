package DailyTemperatures;


class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] warmer = new int[n];
        int[] index = new int[101];

        for (int i = 0; i <= 100; i++)
            index[i] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int t = temperatures[i];
            int s = Integer.MAX_VALUE;
            for (int j = t + 1; j <= 100; j++)
                if (s > index[j])
                    s = index[j];
            warmer[i] = s == Integer.MAX_VALUE ? 0 : s - i;
            index[t] = i;
        }
        return warmer;
    }
}