package SplitArrayLargestSum;


class Solution {

    private int group(long max, int[] nums) {
        int count = 0;
        long sum = 0;
        for (int i : nums) {
            if (sum + i > max) {
                sum = i;
                count++;
            } else {
                sum += i;
            }
        }
        return (sum > 0 ? count + 1 : count);
    }

    public int splitArray(int[] nums, int m) {
        long l = 0, r = 0;
        for (int n : nums) {
            r += n;
            l = Math.max(l, n);
        }

        long min = r;

        while (l <= r) {
            long mid = (l + r) / 2;
            int c = group(mid, nums);
            if (c <= m) {
                min = Math.min(mid, min);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int) min;
    }
}