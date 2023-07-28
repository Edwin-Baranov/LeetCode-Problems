class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int size = m * n;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        List<Integer> result = new ArrayList(size);
        
        for (int i = 0; i < size; top++, bottom--, left++, right--) {
            //top
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
                ++i;
            }
            //right
            for (int j = top + 1; j <= bottom; j++) {
                result.add(matrix[j][right]);
                ++i;
            }
            
            if (top != bottom) {
                //bottom
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                    ++i;
                }
            }
            
            if (left != right) {
                //left
                for (int j = bottom - 1; j > top; j--) {
                    result.add(matrix[j][left]);
                    ++i;
                }
            }
            
        }
        return result;
    }
}