class Solution {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while(start < end) {
            while(start < end && !Character.isDigit(chars[start]) && !Character.isLetter(chars[start])) {
                start++;
            }

            while(start < end && !Character.isDigit(chars[end]) && !Character.isLetter(chars[end])) {
                end--;
            }

            //System.out.println(chars[start] + " " + chars[end]);

            if(start < end && Character.toLowerCase(chars[start]) != Character.toLowerCase(chars[end])) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
