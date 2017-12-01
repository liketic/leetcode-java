package Subsets;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // iterate it
        int n = nums.length;

        List<List<Integer>> subsets = new ArrayList<>(1 << n);

        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++)
                if ((i & (1 << j)) > 0)
                    subset.add(nums[j]);
            subsets.add(subset);
        }
        
        return subsets;
    }
}