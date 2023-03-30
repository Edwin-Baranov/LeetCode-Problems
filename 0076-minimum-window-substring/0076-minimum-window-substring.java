class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";
        
        Map<Character, Integer> counter = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            int count = counter.getOrDefault(c, 0);
            counter.put(c, count + 1);
        }
        
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int length = Integer.MAX_VALUE;
        int n = s.length();
        
        while(right < n) {
            char rightChar = s.charAt(right);
            if (counter.containsKey(rightChar)) {
                counter.put(rightChar, counter.get(rightChar) - 1);
                while (isSatisfied(counter)) {
                    if (right - left < length) {
                        length = right - left;
                        minLeft = left;
                        minRight = right;
                    }
                    char leftChar = s.charAt(left);
                    if (counter.containsKey(leftChar))
                        counter.put(leftChar, counter.get(leftChar) + 1);
                    ++left;
                }
            }
            ++right;
        }
        
        if (length == Integer.MAX_VALUE) {
            return "";
        }
        
        return s.substring(minLeft, minRight + 1);
    }
    
    private boolean isSatisfied(Map<Character, Integer> counter) {
        for (int value : counter.values()) {
            if (value > 0)
                return false;
        }
        return true;
    }
}