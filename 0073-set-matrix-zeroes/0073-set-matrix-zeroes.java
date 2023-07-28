class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        Set<Integer> rows = new HashSet();
        Set<Integer> columns = new HashSet();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        
        for (Integer index : rows.toArray(Integer[]::new)) {
            zeroRow(matrix, index.intValue());
        }
        
        for (Integer index : columns.toArray(Integer[]::new)) {
            zeroColumn(matrix, index.intValue());
        }
    }
    
    private void zeroRow(int[][] matrix, int index) {
        Arrays.fill(matrix[index], 0);
    }
    
    private void zeroColumn(int[][] matrix, int index) {
        for (int[] row : matrix) {
            row[index] = 0;
        }
    }
}