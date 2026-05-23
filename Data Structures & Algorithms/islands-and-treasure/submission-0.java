class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dir = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 0) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] top = q.poll();

            int row = top[0];
            int col = top[1];

            for(int i = 0; i < 4; i++) {
                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];
                int path = 1 + grid[row][col];

                if(
                    newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] != -1 && grid[newRow][newCol] != 0 &&
                    path < grid[newRow][newCol]
                ) {
                    grid[newRow][newCol] = path;
                    q.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}
