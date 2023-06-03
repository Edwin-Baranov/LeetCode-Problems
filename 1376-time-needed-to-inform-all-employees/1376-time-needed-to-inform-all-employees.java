class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        List<Integer>[] subordinates = new ArrayList[n];
        
        //Create empty lists to assosiate subordinates to headID's
        for (int i = 0; i < n; ++i) {
                subordinates[i] = new ArrayList<>();
        }
        
        //Populate lists with subordinates based on manager relation
        for (int i = 0; i < n; ++i) {
            if (i != headID)
                subordinates[manager[i]].add(i);
        }
        
        //run depth first search starting with provided headID
        return dfs(headID, informTime, subordinates);
    }
    
    private int dfs(int headID, int[] informTime, List<Integer>[] subordinates) {
        //Track the longest time of all subordinates
        int addedMinutes = 0;
        
        //For all subordinates get minutes
        for (int sub : subordinates[headID]) {
            //using recurtion go deeper in the tree
            addedMinutes = Math.max(addedMinutes, dfs(sub, informTime, subordinates));
        }
        
        //return the calculated time based on the time it took to notify the current headID and the max of their subordinates
        return informTime[headID] + addedMinutes;
    }
}