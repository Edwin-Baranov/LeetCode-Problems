class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0], b[0]));
        
        int result = 1;
        int right = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > right) {
                right = points[i][1];
                result++;
            } else {
                right = Math.min(right, points[i][1]);
            }
        }
        
        return result;
    }
}