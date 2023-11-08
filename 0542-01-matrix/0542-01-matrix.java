class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        //Make a copy of input
        int[][] result = new int[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[row][col] = mat[row][col];
            }
        } 

        //Check top and left for existing distance
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (result[row][col] == 0)
                    continue;

                int minNeighbor = m * n;
                if (row > 0)
                    minNeighbor = Math.min(minNeighbor, result[row - 1][col]);
                
                if (col > 0)
                    minNeighbor = Math.min(minNeighbor, result[row][col - 1]);
                
                result[row][col] = minNeighbor + 1;
            }
        }
        
        //Check bottom and right for existing distances
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                if (result[row][col] == 0)
                    continue;
                
                int minNeighbor = m * n;
                if (row < m - 1)
                    minNeighbor = Math.min(minNeighbor, result[row + 1][col]);
                
                if (col < n - 1)
                    minNeighbor = Math.min(minNeighbor, result[row][col + 1]);
                
                result[row][col] = Math.min(result[row][col], minNeighbor + 1);
            }
        }
        
        //Result should be fully built using existing known distances
        return result;
    }
}