class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                newBoard[i][j] = updateCell(board, i, j);
            }
        }
        
        System.arraycopy(newBoard, 0, board, 0, newBoard.length);
    }
    
    private int updateCell(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int liveNeighbors = 0;
        
        //top
        if (i > 0) {
            if (j > 0) { liveNeighbors += board[i-1][j-1]; }
            liveNeighbors += board[i-1][j];
            if (j < n - 1) { liveNeighbors += board[i-1][j+1]; }
        }
        
        //middle
        if (j > 0) { liveNeighbors += board[i][j-1]; }
        if (j < n - 1) { liveNeighbors += board[i][j+1]; }
        
        //bottom
        if (i < m - 1) {
            if (j > 0) { liveNeighbors += board[i+1][j-1]; }
            liveNeighbors += board[i+1][j];
            if (j < n - 1) { liveNeighbors += board[i+1][j+1]; }
            
        }
        
        
        //Generate result;
        if (board[i][j] == 0) {
            if (liveNeighbors == 3) {
                return 1;
            }
        } else {
            if (liveNeighbors < 2 || liveNeighbors > 3) {
                return 0;
            }
        }
        
        return board[i][j];
    }
}