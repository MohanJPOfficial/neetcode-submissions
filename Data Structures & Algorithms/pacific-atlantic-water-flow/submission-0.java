class Solution {
    private int m, n;
    private int[][] dir = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacificq = new ArrayDeque<>();
        Queue<int[]> atlanticq = new ArrayDeque<>();

        // top to down
        for(int i = 0; i < m; i++) {

            pacific[i][0] = true;
            atlantic[i][n - 1] = true;

            pacificq.offer(new int[]{i, 0});
            atlanticq.offer(new int[]{i, n - 1});
        }   

        // left to right
        for(int i = 0; i < n; i++) {

            pacific[0][i] = true;
            atlantic[m - 1][i] = true;

            pacificq.offer(new int[]{0, i});
            atlanticq.offer(new int[]{m - 1, i});
        }

        bfs(heights, pacific, pacificq);
        bfs(heights, atlantic, atlanticq);

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, boolean[][] land, Queue<int[]> q) {

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
                    !land[newRow][newCol] && 
                    heights[newRow][newCol] >= heights[curRow][curCol]
                ) {
                    land[newRow][newCol] = true;
                    q.offer(new int[] {newRow, newCol});
                }
            }
        }
    }
}
