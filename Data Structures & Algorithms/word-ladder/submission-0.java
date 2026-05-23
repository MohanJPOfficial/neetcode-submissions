class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int level = 0;

        while(!q.isEmpty()) {

            level++;
            
            int size = q.size();

            for(int i = 0; i < size; i++) {

                String curString = q.poll();

                char[] chars = curString.toCharArray();

                for(int j = 0; j < chars.length; j++) {

                    char original = chars[j];

                    for(char c = 'a'; c <= 'z'; c++) {
                        
                        if(original == c) {
                            continue;
                        }

                        chars[j] = c;

                        String newString = String.valueOf(chars);

                        if(set.contains(newString)) {
                            q.offer(newString);
                            set.remove(newString);
                        }

                        if(newString.equals(endWord)) {
                            return level + 1;
                        }
                    }

                    chars[j] = original;
                }
            }
        }

        return 0; // dummy
    }
}
