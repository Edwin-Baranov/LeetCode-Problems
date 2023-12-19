class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int encoder = 256;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] *= encoder;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                applyAvg(img, i, j, encoder);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] %= encoder;
            }
        }
        
        return img;
    }
    
    private void applyAvg(int[][] img, int row, int col, int encoder) {
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
                sum += img[targetRow][targetCol] / encoder;
            }
        }
        
        img[row][col] += sum / count;
    }
}