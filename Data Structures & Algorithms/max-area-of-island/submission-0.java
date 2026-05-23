class Solution {
    private boolean[][] visited;
    private int[][] dir = {
        {0, -1}, {0, 1}, {-1, 0}, {1, 0}
    };
    private int m, n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        int maxCount = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1 && !visited[i][j]) {
                    int count = bfs(grid, i, j);
                    maxCount = Math.max(count, maxCount);
                }
            }
        }

        return maxCount;
    }  

    private int bfs(int[][] grid, int row, int col) {
        
        visited[row][col] = true;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {row, col});

        int count = 1;

        while(!q.isEmpty()) {

            int[] top = q.poll();
            int curRow = top[0];
            int curCol = top[1];

            for(int i = 0; i < 4; i++) {
                int newRow = curRow + dir[i][0];
                int newCol = curCol + dir[i][1];

                if(
                    newRow >= 0 && newRow < m && 
                    newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1
                ) {
                    q.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                    count++;
                }
            }
        }

        return count;
    }
}
