class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
        int value = 0;
        int total = n * n;
        
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        
        while(value < total) {
            //Top
            for (int i = left; i <= right; ++i) {
                result[top][i] = ++value;
            }

            //Right
            for (int i = top + 1; i <= bottom; ++i) {
                result[i][right] = ++value;
            }

            //Bottom
            for (int i = right - 1; i >= left; --i) {
                result[bottom][i] = ++value;
            }

            //Left
            for (int i = bottom - 1; i > top; --i) {
                result[i][left] = ++value;
            }

            ++top;
            ++left;
            --bottom;
            --right;
        }
        return result;
    }
}