class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        Set<Character> dict = new HashSet();
        
        for (int i = 0; i < n; i++) {
            dict.clear();
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c != '.' && dict.contains(c)) {
                    return false;
                } else {
                    dict.add(c);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            dict.clear();
            for (int j = 0; j < n; j++) {
                char c = board[j][i];
                if (c != '.' && dict.contains(c)) {
                    return false;
                } else {
                    dict.add(c);
                }
            }
        }
        
        for (int i = 0; i < n; i += 3) {
            for (int j = 0; j < n; j += 3) {
                dict.clear();
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