class Solution {
    public int minimumMoves(int[][] grid) {
        return dfs(grid, 0, 0);
    }
    
    private int dfs(int[][] grid, int row, int colum) {
        if (row == 3) return 0;
        if (colum == 3) return dfs(grid, row + 1, 0);
        
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i][j] > 0) {
                    grid[i][j]--;
                    int s = Math.abs(i - row) + Math.abs(j - colum) + dfs(grid, row, colum + 1);
                    result = Math.min(result, s);
                    grid[i][j]++;
                }
            }
        }
        
        return result;
    }
}