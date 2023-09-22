class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int n = s.length();
        
        int left = 0;
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (window.contains(c)) {
                window.remove(s.charAt(left++));
            }
            
            window.add(c);
            
            result = Math.max(result, i - left + 1);
        }
        
        return result;
    }
}