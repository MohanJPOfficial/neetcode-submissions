class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int totalFruits = 0;
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    totalFruits++;
                
                } else if(grid[i][j] == 2) {
                    q.offer(new int[] {i, j});
                }
            }
        }

        if(totalFruits == 0) {
            return 0;
        }

        // perform bfs
        int totalTime = 0;
        int[][] dir = {
            {0, -1}, {0, 1}, {-1, 0}, {1, 0}
        };

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {
                
                int[] top = q.poll();
                int row = top[0];
                int col = top[1];

                //System.out.println(Arrays.toString(top));

                // 4 directions
                for(int d = 0; d < 4; d++) {
                    int newRow = row + dir[d][0];
                    int newCol = col + dir[d][1];

                    if(
                        newRow >= 0 && newRow < m &&
                        newCol >= 0 && newCol < n &&
                        grid[newRow][newCol] == 1
                    ) {
                        grid[newRow][newCol] = 2;
                        q.offer(new int[] {newRow, newCol});
                        totalFruits--;
                    }
                }
            }

            totalTime++;

            //System.out.println("Time : " + totalTime);
            //System.out.println();
        }

        return (totalFruits == 0) ? totalTime - 1 : -1;
    }
}
