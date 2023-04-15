class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return dp(n, memo);
    }
    
    private int dp(int i, int[] memo) {
        if (i <= 2) {
            return i;
        }
        if (memo[i] == 0) {
            memo[i] = dp(i-1, memo) + dp(i-2, memo);
        }
        return memo[i];
    }
}