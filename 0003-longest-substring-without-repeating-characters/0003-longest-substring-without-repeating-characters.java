class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap();
        int n = s.length();
        int result = 0;
        
        for (int left = 0, right = 0; right < n; right++) {
            char r = s.charAt(right);
            
            if (chars.containsKey(r)) {
                left = Math.max(left, chars.get(r));
            }
                        
            chars.put(r, right + 1);
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}