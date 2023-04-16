class Solution {
    int[] cost;
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;
        this.memo = new int[cost.length+1];
        return dp(cost.length);
    }
    
    private int dp(int i) {
        if (i <= 1) return 0;
        if (memo[i] != 0) return memo[i];
        
        memo[i] = Math.min(dp(i-1) + cost[i-1], dp(i-2) + cost[i-2]);
        
        return memo[i];
    }
}