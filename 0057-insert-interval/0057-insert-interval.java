class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        int listIndex = 0;
        int[][] list = new int[intervals.length + 1][];
        LinkedList<int[]> result = new LinkedList();
        
        for (int[] interval : intervals) {
            if (newInterval[0] < interval[0] && !isIntervalInserted) {
                list[listIndex++] = newInterval;
                isIntervalInserted = true;
            }
            list[listIndex++] = interval;
        }
        
        if (!isIntervalInserted) {
            list[listIndex++] = newInterval;
            isIntervalInserted = true;
        }
        
        for (int[] interval : list) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                int[] last = result.getLast();
                last[1] = Math.max(last[1], interval[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}