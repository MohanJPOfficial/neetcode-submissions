class Solution {

    private int[][] dir = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    private int m, n;

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // top to down
        for(int row = 0; row < m; row++) {
            if(board[row][0] == 'O') {
                fillInvalidNeighbours(board, row, 0);
            }

            if(board[row][n - 1] == 'O') {
                fillInvalidNeighbours(board, row, n - 1);
            }
        }

        // left to right
        for(int col = 0; col < n; col++) {
            if(board[0][col] == 'O') {
                fillInvalidNeighbours(board, 0, col);
            }

            if(board[m - 1][col] == 'O') {
                fillInvalidNeighbours(board, m - 1, col);
            }
        }

        // surround valid region
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                
                } else if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void fillInvalidNeighbours(char[][] board, int row, int col) {

        board[row][col] = '#';

        for(int i = 0; i < 4; i++) {
            int newRow = row + dir[i][0];
            int newCol = col + dir[i][1];

            if(
                newRow >= 0 && newRow < m && 
                newCol >= 0 && newCol < n && 
                board[newRow][newCol] == 'O'
            ) {
                fillInvalidNeighbours(board, newRow, newCol);
            }
        }
    }
}
