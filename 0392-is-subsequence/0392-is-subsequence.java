class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        
        if (n > m)
            return false;
        
        int i = 0, j = 0;
        
        while(i < n && j < m) {
            if (i < n && s.charAt(i) == t.charAt(j))
                i++;
            
            j++;
        }
        
        return i == n;
    }
}