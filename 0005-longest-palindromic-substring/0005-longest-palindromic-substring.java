class Solution {
    public String longestPalindrome(String s) {
        int left = 0, right = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int oddLength = expand(i, i, s);
            if (oddLength > right - left + 1) {
                int dist = oddLength / 2;
                left = i - dist;
                right = i + dist;
            }
            
            int evenLength = expand(i, i + 1, s);
            if (evenLength > right - left + 1) {
                int dist = (evenLength / 2) - 1;
                left = i - dist;
                right = i + 1 + dist;
            }
        }
        
        return s.substring(left, right + 1);
    }
    
    private int expand(int i, int j, String s) {
        int left = i;
        int right = j;
        
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}