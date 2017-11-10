package PartitiontoKEqualSumSubsets;


import java.util.ArrayList;
import java.util.List;

class Solution {

    private boolean noConflict(int v, Integer[] arr) {
        for (int a : arr) {
            if ((a & v) > 0)
                return false;
        }
        return true;
    }

    private int mergeSubset(int v, Integer[] arr) {
        for (int a : arr) {
            v |= a;
        }
        return v;
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        if (sum % k != 0)
            return false;
        sum /= k;
        List<Integer[]> subsets = new ArrayList<>();
        int num = nums.length, s;
        int fullSet = (1 << num) - 1;

        for (int i = 1; i <= fullSet; i++) {
            s = 0;
            for (int j = 0; j < num; j++) {
                if ((i & (1 << j)) > 0) {
                    s += nums[j];
                    if (s > sum)
                        break;
                }
            }
            if (s != sum)
                continue;
            if (i == fullSet) {
                // Only one subset is the full set
                return true;
            }
            for (int h = subsets.size() - 1; h >= 0; h--) {
                Integer[] subset = subsets.get(h);
                if (noConflict(i, subset)) {
                    if (mergeSubset(i, subset) == fullSet)
                        return true;
                    Integer[] union = new Integer[subset.length + 1];
                    System.arraycopy(subset, 0, union, 0, subset.length);
                    union[subset.length] = i;
                    subsets.add(union);
                }
            }
            Integer[] newSubset = new Integer[]{i};
            subsets.add(newSubset);
        }
        return false;
    }
}