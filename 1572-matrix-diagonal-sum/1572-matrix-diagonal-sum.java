class Solution {
    public int diagonalSum(int[][] mat) {
        int count = 0;
        int n = mat.length;
        
        for (int i = 0; i < mat.length; ++i) {
            count += mat[i][i];
        }
        
        for (int i = 0; i < n; ++i) {
            count += mat[i][n - 1 - i];
        }
        
        if (n % 2 == 1) {
            int i = n/2;
            count -= mat[i][i];
        }
        return count;
    }
}