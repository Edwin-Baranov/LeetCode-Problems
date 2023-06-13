class Solution {
    public int equalPairs(int[][] grid) {
        Map<String, Integer> rows = new HashMap<>();
        int result = 0;
        
        int n = grid.length;
        
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sb.append(grid[i][j]);
                if (j != n - 1) {
                    sb.append(" ");
                }
            }
            String rowString = sb.toString();
            rows.put(rowString, 1 + rows.getOrDefault(rowString, 0));
        }
        
        for (int i = 0; i < n; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; ++j) {
                sb.append(grid[j][i]);
                if (j != n - 1) {
                    sb.append(" ");
                }
            }
            
            result += rows.getOrDefault(sb.toString(), 0);          
        }
        return result;
    }
}