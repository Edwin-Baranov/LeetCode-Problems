class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        
        return n - lps(s, 0, n-1, dp);
    }
    
    private int lps(String s, int i, int j, int[][] dp) {
        if (i == j)
            return 1;
        
        if (i > j)
            return 0;
        
        if (dp[i][j] != -1)
            return dp[i][j];
        
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + lps(s, i+1, j-1, dp);
        }
        
        dp[i][j] = Math.max(lps(s, i+1, j, dp), lps(s, i, j-1, dp));
        return dp[i][j];
    }
}