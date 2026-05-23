class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        int[] res = new int[numCourses];
        int index = 0;

        while(!q.isEmpty()) {
            int top = q.poll();
            res[index++] = top;

            for(int edge : adj.get(top)) {
                indegree[edge]--;

                if(indegree[edge] == 0) {
                    q.offer(edge);
                }
            }
        }

        return (index == numCourses) ? res : new int[] {};
    }
}
