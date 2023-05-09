class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, top = 0;
        int right = matrix[0].length - 1, bottom = matrix.length - 1;
        
        while (result.size() < rows * columns) {
            for (int i = left; i <= right; ++i) {
                result.add(matrix[top][i]);
            }
        
            for (int i = top + 1; i <= bottom; ++i) {
                result.add(matrix[i][right]);
            }
            
            if (top != bottom) {
                for (int i = right - 1; i >= left; --i) {
                    result.add(matrix[bottom][i]);
                }
            }
            
            if (left != right) {
                for (int i = bottom - 1; i > top; --i) {
                    result.add(matrix[i][left]);
                }
            }
            
            ++left;
            ++top;
            --right;
            --bottom;
        }
        return result;
    }
}