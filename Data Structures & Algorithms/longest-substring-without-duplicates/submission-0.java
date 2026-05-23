class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0;
        int end = 0;

        int[] hashing = new int[128];
        Arrays.fill(hashing, -1);
        
        int max = 0;

        while(end < n) {
            
            char c = s.charAt(end);

            if(hashing[c] >= start) {
                start = hashing[c] + 1;
            }

            max = Math.max(max, end - start + 1);
            hashing[c] = end;
            end++;
        }

        return max;
    }
}
