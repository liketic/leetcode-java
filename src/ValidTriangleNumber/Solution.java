package ValidTriangleNumber;


import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count
 * the number of triplets chosen from the array that can make triangles
 * if we take them as side lengths of a triangle.
 * <pre>
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * </pre>
 */
class Solution {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // x < nums[i] + nums[j]
                // x > nums[j] - nums[i]
                int l, r;
                
                // Find the maximum s which nums[s] < nums[i] + nums[j]
                l = j + 1;
                r = n - 1;
                int s = j;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if (nums[m] < nums[i] + nums[j]) {
                        if (s < m) s = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                if (s == j) // Not found
                    continue;

                // Find the minimum e which nums[e] > nums[j] - nums[i]
                l = j + 1;
                r = n - 1;
                int e = n;

                while (l <= r) {
                    int m = (l + r) / 2;
                    if (nums[m] > nums[j] - nums[i]) {
                        if (e > m) e = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                if (e == n) // Not found
                    continue;
                count += s - e + 1;
            }
        }

        return count;
    }
}