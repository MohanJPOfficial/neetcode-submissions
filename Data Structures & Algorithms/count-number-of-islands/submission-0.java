class Solution {
    private int rows, cols;
    private boolean[][] visited;
    private int[][] dir = {
        {0, -1}, {0, 1}, {-1, 0}, {1, 0},
    };

    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int total = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                
                if(grid[i][j] == '1' && !visited[i][j]) {
                    total++;
                    dfs(grid, i, j);
                }
            }
        }

        return total;
    }

    private void dfs(char[][] grid, int row, int col) {
        
        visited[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];

            if(
                newRow >= 0 && newRow < rows && 
                newCol >= 0 && newCol < cols && 
                grid[newRow][newCol] == '1' && !visited[newRow][newCol]
            ) {
                dfs(grid, newRow, newCol);
            }
        }
    }
}
