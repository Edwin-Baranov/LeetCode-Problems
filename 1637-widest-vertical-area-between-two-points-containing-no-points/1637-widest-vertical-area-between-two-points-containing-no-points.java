class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] values = new int[points.length];
        
        for (int i = 0; i < points.length; i++) {
            values[i] = points[i][0];
        }
        
        Arrays.sort(values);
        
        int result = 0;
        for (int i = 0; i < points.length - 1; i++) {
            result = Math.max(result, values[i+1] - values[i]);
        }
        
        return result;
    }
}