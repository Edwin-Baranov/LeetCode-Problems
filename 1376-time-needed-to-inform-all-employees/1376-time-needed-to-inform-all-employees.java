class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] subordinates = new ArrayList[n];
        
        for (int i = 0; i < n; ++i) {
                subordinates[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; ++i) {
            if (i != headID)
                subordinates[manager[i]].add(i);
        }
        
        return dfs(headID, informTime, subordinates);
    }
    
    private int dfs(int headID, int[] informTime, List<Integer>[] subordinates) {
        int addedMinutes = 0;
        
        for (int sub : subordinates[headID]) {
            addedMinutes = Math.max(addedMinutes, dfs(sub, informTime, subordinates));
        }
        
        return informTime[headID] + addedMinutes;
    }
}