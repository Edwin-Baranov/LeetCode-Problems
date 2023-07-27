class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        
        return isValidRows(board) && isValidColumns(board) && isValidBoxes(board);
    }
    
    private boolean isValidRows(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> dict = new HashSet();
            for (int j = 0; j < board.length; j++) {
                char c = board[i][j];
                if (c != '.' && dict.contains(c)) {
                    return false;
                } else {
                    dict.add(c);
                }
            }
        }
        return true;
        
    }
    
    private boolean isValidColumns(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> dict = new HashSet();
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                if (c != '.' && dict.contains(c)) {
                    return false;
                } else {
                    dict.add(c);
                }
            }
        }
        return true;
    }
    
    private boolean isValidBoxes(char[][] board) {
        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                Set<Character> dict = new HashSet();
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        char c = board[k][l];
                        if (c != '.' && dict.contains(c)) {
                            return false;
                        } else {
                            dict.add(c);
                        }
                    }
                }
            }
        }
        return true;
    }
}