class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] edgeCells = new int[n][m];
        
        int landCount = 0;
        
        for (int i = 0; i < n; ++i) {
            if (grid[i][0] == 1 && edgeCells[i][0] == 0) {
                checkConnected(i, 0, n, m, grid, edgeCells);
            }
            
            if (grid[i][m-1] == 1 && edgeCells[i][m-1] == 0) {
                checkConnected(i, m-1, n, m, grid, edgeCells);
            }
        }
        
        for (int i = 0; i < m; ++i) {
            if (grid[0][i] == 1 && edgeCells[0][i] == 0) {
                checkConnected(0, i, n, m, grid, edgeCells);
            }
            
            if (grid[n-1][i] == 1 && edgeCells[n-1][i] == 0) {
                checkConnected(n-1, i, n, m, grid, edgeCells);
            }
        }
        
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                if (edgeCells[i][j] == 0 && grid[i][j] == 1) {
                    ++landCount;
                }
            }
        }
        return landCount;
    }
    
    private void checkConnected(int y, int x, int n, int m, int[][] grid, int[][] edgeCells) {
        if (y < 0 || y >= n || x < 0 || x >= m || grid[y][x] == 0 || edgeCells[y][x] == 1) {
            return;
        }
        
        edgeCells[y][x] = 1;
        
        //left
        checkConnected(y, x - 1, n, m, grid, edgeCells);
        //right
        checkConnected(y, x + 1, n, m, grid, edgeCells);        
        //up
        checkConnected(y - 1, x, n, m, grid, edgeCells);        
        //down
        checkConnected(y + 1, x, n, m, grid, edgeCells);
    }
}