class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRow = false;
        boolean firstColumn = false;
        
        //Record if firstColumn contains any 0's
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColumn = true;
                break;
            }
        }
        
        //Record if firstRow contains any 0's
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                firstRow = true;
                break;
            }
        }
        
        //for every item except first row and column
        //record a 0 within first row and column to indicate
        //row and column that needs updating
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //Iterate along first row looking for 0's
        //Apply 0 to all elements in column when 0 is found
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        
        //Iterate along first column looking for 0's
        //Apply 0 to all elements in row when 0 is found
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstColumn) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
        
        if (firstRow) {
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}