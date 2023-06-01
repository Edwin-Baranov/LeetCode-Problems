class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        int[][] directions = new int[][]{{1, 1}, {1, 0}, {0, 1}, {1, -1}, {-1, 1}, {0, -1}, {-1, 0}, {-1, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        grid[0][0] = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int column = curr[1];
                
            if (row == n - 1 && column == n - 1) {
                return grid[row][column];
            }
            
            for (int[] direction : directions) {
                int y = curr[0] + direction[0];
                int x = curr[1] + direction[1];
                if (y < 0 || y >= n || x < 0 || x >= n || grid[y][x] > 0) {
                    continue;
                }
                grid[y][x] = grid[row][column] + 1;
                queue.add(new int[] {y, x});
            }
        }
        return -1;
    }
}