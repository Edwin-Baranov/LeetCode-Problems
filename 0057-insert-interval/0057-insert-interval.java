class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        boolean isIntervalInserted = false;
        LinkedList<int[]> list = new LinkedList();
        LinkedList<int[]> result = new LinkedList();
        
        for (int[] interval : intervals) {
            if (newInterval[0] < interval[0]) {
                list.add(newInterval);
                isIntervalInserted = true;
            }
            list.add(interval);
        }
        
        if (!isIntervalInserted) {
            list.add(newInterval);
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