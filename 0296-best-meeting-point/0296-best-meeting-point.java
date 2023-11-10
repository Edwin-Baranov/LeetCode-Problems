class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    rows.add(row);
                    cols.add(col);
                }
            }
        }
        
        Collections.sort(cols);
        
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        
        return minDistance1D(rows, row) + minDistance1D(cols, col);
    }

    private int minDistance1D(List<Integer> points, int origin) {
        int i = 0, j = points.size() - 1;
        int result = 0;
        while (i < j) {
            result += points.get(j) - points.get(i);
            i++;
            j--;
        }
        return result;
    }
}