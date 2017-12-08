package ContainerWithMostWater;


/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
class Solution {


    public int maxArea(int[] height) {
        // It's really tricky here.

        int l = 0, r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            if (maxArea < area)
                maxArea = area;
            if (height[l] < height[r])
                // if height[l] < height[r], then move l to l+1, because if move r to r-1,
                // then the area of [l, r-1] is not possible to larger than [l, r]. No matter
                // what's height[l+1], it's the only way to move.
                l++;
            else
                r--;
        }
        return maxArea;
    }
}