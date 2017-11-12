package FindPivotIndex;


class Solution {

    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            rightSum[i] = nums[i] + rightSum[i + 1];
        }
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (s == rightSum[i + 1])
                return i;
            s += nums[i];
        }
        return -1;
    }
}