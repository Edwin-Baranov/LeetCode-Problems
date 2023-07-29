class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        Map<Character, Integer> charCount = new HashMap();
        
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : t.toCharArray()) {
            int count = charCount.getOrDefault(c, 0);
            if (count == 0) {
                return false;
            } else {
                charCount.put(c, --count);
            }
        }
        
        return true;
    }
}