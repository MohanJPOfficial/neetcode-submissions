class Solution {
    
    private boolean[] visited;
    private List<Integer>[] adj;

    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n];
        adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adj[from].add(to);
            adj[to].add(from);
        }

        int count = 0;
        
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i);
                count++;
            }
        }

        return count;
    }

    private void bfs(int node) {
        visited[node] = true;

        Queue<Integer> q = new ArrayDeque<>();  
        q.offer(node);

        while(!q.isEmpty()) {
            int top = q.poll();

            for(int edge : adj[top]) {
                if(!visited[edge]) {
                    visited[edge] = true;
                    q.offer(edge);
                }
            }
        }
    }
}
