class Solution {
    int[][] memo;
    
    public int getLengthOfOptimalCompression(String s, int k) {
        memo = new int[s.length()][k+1];
        
        for (int[] row : memo)
            Arrays.fill(row, -1);
        
        return dp(s, 0, k);
    }
    
    private int dp(String s, int index, int k) {
        int n = s.length();
        if (k < 0) return n;
        if (n <= index + k) return 0;
        
        int result = memo[index][k];
        if (result != -1) return result;
        
        result = dp(s, index + 1, k - 1);
        int length = 0, same = 0, diff = 0;
        
        for (int j = index; j < n && diff <= k; j++) {
            
            if (s.charAt(j) == s.charAt(index)) {
                same++;
                if (same <= 2 || same == 10 || same == 100) length++;
            } else {
                diff++; 
            }
            result = Math.min(result, length + dp(s, j + 1, k - diff)); 
        }
        memo[index][k] = result;
        return result;
    }
}