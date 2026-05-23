class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();        
        Map<Character, Integer> indegree = new HashMap<>();
        int n = words.length;

        for(String s : words) {
            for(char c : s.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 1; i < n; i++) {

            String prev = words[i - 1];
            String cur = words[i];

            int length = Math.min(prev.length(), cur.length());

            // invalid dictionary
            if(prev.length() > cur.length() && prev.contains(cur)) {
                return "";
            }

            for(int j = 0; j < length; j++) {
                    
                if(prev.charAt(j) != cur.charAt(j)) {
                    
                    if(!adj.get(prev.charAt(j)).contains(cur.charAt(j))) {
                        adj.get(prev.charAt(j)).add(cur.charAt(j));
                        indegree.put(cur.charAt(j), indegree.get(cur.charAt(j)) + 1);
                    }   

                    break;
                }
            }
        }

        System.out.println("adj >> " + adj);
        System.out.println("indegree >> " + indegree);

        Queue<Character> q = new ArrayDeque<>();
        for(char key : indegree.keySet()) {
            if(indegree.get(key) == 0) {
                q.offer(key);
            }
        }

        StringBuilder sb = new StringBuilder();
        
        while(!q.isEmpty()) {
            char top = q.poll();
            sb.append(top);

            for(char edge : adj.get(top)) {

                indegree.put(edge, indegree.get(edge) - 1);

                if(indegree.get(edge) == 0) {
                    q.offer(edge);
                }
            }
        }

        return (sb.length() == indegree.size()) ? String.valueOf(sb) : "";
    }
}
