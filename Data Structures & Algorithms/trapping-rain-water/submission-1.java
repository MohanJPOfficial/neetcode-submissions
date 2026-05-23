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

        int leftMax = 0;
        int rightMax = 0;
        
        int left = 0;
        int right = n - 1;

        while(left < right) {

            if(height[left] < height[right]) {
                leftMax = Math.max(leftMax, height[left]);
                totalWater += (leftMax - height[left]);

                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);

                totalWater += (rightMax - height[right]);
                right--;
            }
        }

        return totalWater;
    }
}
