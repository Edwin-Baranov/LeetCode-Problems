class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        //Top, Bottom
        for (int i = 0; i < n; i++) {
            isEdgeLand(board, 0, i);
            isEdgeLand(board, m - 1, i);
        }
        
        //Left, Right
        for (int i = 0; i < m; i++) {
            isEdgeLand(board, i, 0);
            isEdgeLand(board, i, n - 1);
        }
        
        for (char[] chars : board) {
            for (int i = 0; i < n; i++) {
                if (chars[i] == 'O') {
                    chars[i] = 'X';
                } else if (chars[i] == 'E') {
                    chars[i] = 'O';
                }
            }
        }
    }
    
    private void isEdgeLand(char[][] board, int y, int x) {
        if (y < 0 || x < 0 || y >= board.length || x >= board[0].length || board[y][x] != 'O')
            return;
        
        board[y][x] = 'E';
        
        isEdgeLand(board, y - 1, x);
        isEdgeLand(board, y + 1, x);
        isEdgeLand(board, y, x - 1);
        isEdgeLand(board, y, x + 1);
    }
}