class Solution {

    private List<Integer>[] adj;
    private boolean[] visited;

    public boolean validTree(int n, int[][] edges) {
        adj = new ArrayList[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            adj[from].add(to);
            adj[to].add(from);
        }

        if(!bfs(0)) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int node) {
        
        visited[node] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {node, -1});

        while(!q.isEmpty()) {
            
            int[] top = q.poll();
            int curNode = top[0];
            int parent = top[1];

            // System.out.println(Arrays.toString(top));

            for(int edge : adj[curNode]) {

                if(!visited[edge]) {
                    visited[edge] = true;
                    q.offer(new int[] {edge, curNode});

                } else if(edge != parent) {
                    System.out.println();

                    for(int[] arr : q) {
                        System.out.println(Arrays.toString(arr));
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
