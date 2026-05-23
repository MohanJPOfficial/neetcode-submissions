class Solution {
    public int characterReplacement(String s, int k) {
        
        int n = s.length();

        int max = 0;
        int highFreq = 0;

        int[] hashing = new int[26];

        int start = 0;
        int end = 0;

        while(end < n) {
            
            char curChar = s.charAt(end);
            hashing[curChar - 'A']++;

            highFreq = Math.max(highFreq, hashing[curChar - 'A']);

            if(end - start + 1 - highFreq > k) {
                hashing[s.charAt(start) - 'A']--;
                start++;
            }

            max = Math.max(max, end - start + 1);

            end++;
        }

        return max;
    }
}
