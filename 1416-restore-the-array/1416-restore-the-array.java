class Solution {
    int mod = 1000000007;
    public int numberOfArrays(String s, int k) {
        int m = s.length();
        int[] dp = new int[m + 1];
        return dfs(s, k, 0, dp);
    }
    
    private int dfs (String s, int k, int start, int[] dp) {
        if (dp[start] != 0)
            return dp[start];
        
        if (start == s.length())
            return 1;
        
        if (s.charAt(start) == '0')
            return 0;
        
        int count = 0;
        for (int end = start; end < s.length(); ++end) {
            String currNumber = s.substring(start, end + 1);
            if (Long.parseLong(currNumber) > k)
                break;
            
            count = (count + dfs(s, k, end + 1, dp)) % mod;
        }
        
        dp[start] = count;
        return count;
    }
}