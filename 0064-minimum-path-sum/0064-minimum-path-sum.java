class Solution {
    public int minPathSum(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        int[][] minTravel = new int[x][y];
        
        minTravel[0][0] = grid[0][0];
        
        for (int i = 1; i < x; ++i) {
            minTravel[i][0] = minTravel[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < y; ++i) {
            minTravel[0][i] = minTravel[0][i - 1] + grid[0][i];
        }
        
        for (int i = 1; i < x; ++i) {
            for (int j = 1; j < y; ++j) {
                minTravel[i][j] = Math.min(minTravel[i - 1][j], minTravel[i][j - 1]) + grid[i][j];
            }
        }
        return minTravel[x - 1][y - 1];
    }
}