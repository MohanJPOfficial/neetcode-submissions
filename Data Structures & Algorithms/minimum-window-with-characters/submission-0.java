class Solution {
    /**
    1. take t string frequency count
    2. iterate s while iterating reduce the frequency count, also use counter var
    3. if counter var is equal to t string length,
    4. we got the possible answer, now shrink the window til counter remains t length
     */
    public String minWindow(String s, String t) {
        
        int n1 = s.length();
        int n2 = t.length(); 

        int minLen = (int)1e6;
        int sIndex = -1;
        int count = 0;

        int[] hashing = new int[128];

        for(char c : t.toCharArray()) {
            hashing[c]++;
        }

        int start = 0;
        int end = 0;

        while(end < n1) {
            
            if(hashing[s.charAt(end)] > 0) {
                count++;
            }

            hashing[s.charAt(end)]--;
            
            while(count == n2) {
                
                if(end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    sIndex = start;
                }

                if(hashing[s.charAt(start)] == 0) {
                    count--;
                }

                hashing[s.charAt(start)]++;

                start++;
            }

            end++;
        }

        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }
}
