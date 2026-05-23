class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }   

        int[] indegree = new int[numCourses];
        for(int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];

            adj.get(from).add(to);
            indegree[to]++;
        }  

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;
        while(!q.isEmpty()) {
            int top = q.poll();
            count++;

            for(int edge : adj.get(top)) {
                indegree[edge]--;

                if(indegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        return count == numCourses;
    }
}
