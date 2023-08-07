class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0, right = m * n;
        
        while (left < right) {
            int mid = (right - left) / 2 + left;
            
            int row = mid / n;
            int col = mid % n;
            
            int found = matrix[row][col];
            if (found == target)
                return true;
            
            if (found < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}