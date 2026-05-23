class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int start = 0;
        int end = n - 1;

        int max = 0;

        while(start < end) {
            int min = Math.min(heights[start], heights[end]);

            max = Math.max(max, min * (end - start));

            if(heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        return max;   
    }
}
