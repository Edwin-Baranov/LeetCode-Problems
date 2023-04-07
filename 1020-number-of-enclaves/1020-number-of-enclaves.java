class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int landCount = 0;
        
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (y == 0 || y == n-1 || x == 0 || x == m-1)
                    removeConnected(y, x, n, m, grid);
            }
        }
        
        for (int y = 0; y < n; ++y) {
            for (int x = 0; x < m; ++x) {
                if (grid[y][x] == 1) {
                    ++landCount;
                }
            }
        }
        return landCount;
    }
    
    private void removeConnected(int y, int x, int n, int m, int[][] grid) {
        if (y < 0 || y >= n || x < 0 || x >= m || grid[y][x] == 0) {
            return;
        }
        
        grid[y][x] = 0;
        
        //left
        removeConnected(y, x - 1, n, m, grid);
        //right
        removeConnected(y, x + 1, n, m, grid);        
        //up
        removeConnected(y - 1, x, n, m, grid);        
        //down
        removeConnected(y + 1, x, n, m, grid);
    }
}