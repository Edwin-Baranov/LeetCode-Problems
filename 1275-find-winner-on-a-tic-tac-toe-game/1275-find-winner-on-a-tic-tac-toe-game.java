class Solution {
    public String tictactoe(int[][] moves) {
        int m = moves.length;
        int n = 3;
        int[] rows = new int[n], cols = new int[n];
        int diag = 0, anti_diag = 0;
        
        int player = -1;
        
        for (int[] move : moves){
            player *= -1;
            
            int row = move[0], col = move[1];
            rows[row] += player;
            cols[col] += player;
            
            if (row == col){
                diag += player;
            }
            
            if (row + col == n - 1){
                anti_diag += player;
            }
        }
        
        
        if (Math.abs(rows[moves[m-1][0]]) == n || Math.abs(cols[moves[m-1][1]]) == n || 
            Math.abs(diag) == n || Math.abs(anti_diag) == n){
            return player == 1 ? "A" : "B";
        }
        
        return moves.length == n * n ? "Draw" : "Pending";
    }
}