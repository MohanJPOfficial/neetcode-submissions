class Solution {
    /**
        brute force -> generate prefix max and suffix max height then calculate

        height = 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        prefix = 0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3
        suffix = 3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1

        Better -> only build suffix max array, for prefix max calculate on the fly

        Optimal -> use two pointer approch
            track leftMax and rightMax then calculate height by min of left and rightMax
     */

    public int trap(int[] height) {
        int n = height.length;
        int totalWater = 0;

        int[] suffix = new int[n];
        suffix[n - 1] = height[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], height[i]);
        }

        int leftMax = height[0];

        for(int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, height[i]);

            totalWater += (Math.min(leftMax, suffix[i]) - height[i]);
        }

        return totalWater;
    }
}
