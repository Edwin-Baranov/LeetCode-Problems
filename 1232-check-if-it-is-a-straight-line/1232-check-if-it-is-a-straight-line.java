class Solution {
    int getYDiff(int[] a, int[] b) {
        return a[1] - b[1];
    }
    
    int getXDiff(int[] a, int[] b) {
        return a[0] - b[0];
    }
    
    public boolean checkStraightLine(int[][] coordinates) {
        int[] first = coordinates[0];
        
        int deltaY = coordinates[1][1] - first[1];
        int deltaX = coordinates[1][0] - first[0];
        
        for (int i = 2; i < coordinates.length; i++) {
            int newDeltaY = coordinates[i][1] - first[1];
            int newDeltaX = coordinates[i][0] - first[0];
            
            if (deltaY * newDeltaX != deltaX * newDeltaY)
                return false;
        }
        return true;
    }
}