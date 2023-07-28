class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                updateCell(board, i, j);
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                } else if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private void updateCell(int[][] board, int row, int column) {
        int m = board.length;
        int n = board[0].length;
        int liveNeighbors = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                int y = row + i - 1;
                int x = column + j - 1;
                
                if (y >= 0 && y < m && x >= 0 && x < n) {
                    int node = Math.abs(board[y][x]);
                    liveNeighbors += (node == 1 ? 1 : 0);
                }
            }
        }
        
        if (board[row][column] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
            board[row][column] = -1;
        } else if (board[row][column] == 0 && liveNeighbors == 3) {
            board[row][column] = 2;
        }
    }
}