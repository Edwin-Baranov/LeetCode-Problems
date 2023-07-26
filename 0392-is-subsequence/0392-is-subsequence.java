class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        
        if (n > m)
            return false;
        
        int i = 0, j = 0;
        
        while(j < n && i < m) {
            if (j < n && s.charAt(j) == t.charAt(i))
                j++;
            
            i++;
        }
        
        return j == n;
    }
}