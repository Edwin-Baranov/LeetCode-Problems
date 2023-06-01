class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        boolean[][] isVisited = new boolean[n][n];
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{0, 0});
        isVisited[0][0] = true;
        int count = 1;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] curr = dq.poll();
                
                if (curr[0] == n - 1 && curr[1] == n - 1) {
                    return count;
                }
                for (int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 1 || isVisited[x][y]) {
                        continue;
                    }
                    dq.add(new int[]{x, y});
                    isVisited[x][y] = true;
                }
            }
            count++;
        }
        return -1;
    }
}