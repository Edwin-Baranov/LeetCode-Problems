class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int ans = 0;
        int k = Integer.MIN_VALUE;
        
        for (int i = 0; i < intervals.length; i++) {            
            if (intervals[i][0] >= k) {
                k = intervals[i][1];
            } else {
                ans++;
            }
        }
        return ans;
    }
}