class Solution {
    public String tictactoe(int[][] moves) {
        int[] rows = new int[3], cols = new int[3];
        int diagonal = 0, antiDiagonal = 0;
        for (int i = 0; i < moves.length; ++i) {
            int player = i % 2 == 0 ? 1 : -1;
            int row = moves[i][0], col = moves[i][1];
            rows[row] += player;
            cols[col] += player;
            if (row == col) {
                diagonal += player;
            }
            if (row + col == 2) {
                antiDiagonal += player;
            }
            if (Math.abs(rows[row]) == 3 || Math.abs(cols[col]) == 3 || Math.abs(diagonal) == 3 || Math.abs(antiDiagonal) == 3) {
                return player == 1 ? "A" : "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }
}