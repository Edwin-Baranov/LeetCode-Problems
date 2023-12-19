class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        
        int[][] result = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                applyAvg(img, result, i, j);
            }
        }
        
        return result;
    }
    
    private void applyAvg(int[][] img, int[][] result, int row, int col) {
        int count = 0;
        int sum = 0;
        int targetRow, targetCol;
        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                targetRow = row + i;
                targetCol = col + j;
                
                if (targetRow < 0 || targetCol < 0 || targetRow >= img.length || targetCol >= img[0].length)
                    continue;
                
                count++;
                sum += img[targetRow][targetCol];
            }
        }
        
        result[row][col] = sum / count;
    }
}