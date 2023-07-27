class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> count = new HashMap<>();
        int n = s.length();
        int result = 0;
        
        for (int left = 0, right = 0; right < n; right++) {
            char r = s.charAt(right);
            
            while (count.getOrDefault(r, 0) > 0) {
                char l = s.charAt(left++);
                count.put(l, count.get(l) - 1);
            }
            
            count.put(r, count.getOrDefault(r, 0) + 1);
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}