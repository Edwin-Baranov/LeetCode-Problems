class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        
        int[] dp = new int[128];
        
        for (char c : t.toCharArray()) {
            ++dp[c];
        }
        
        int left = 0, right = 0;
        int minLeft = 0;
        int length = Integer.MAX_VALUE;
        int counter = t.length();
        int n = s.length();
        
        while(right < n) {
            char rightChar = s.charAt(right);
            if (dp[rightChar] > 0)
                --counter;
            
            --dp[rightChar];
            
            while (counter == 0) {
                if (right - left < length) {
                    length = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                ++dp[leftChar];
                if (dp[leftChar] > 0)
                    ++counter;
                ++left;
            }
            ++right;
        }
        
        if (length == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minLeft, minLeft + length + 1);
    }
}