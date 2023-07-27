class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> neededChars = new HashMap();
        Map<Character, Integer> seenChars = new HashMap();
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int subLength = -1;
        int m = s.length();
        
        for (char c : t.toCharArray()) {
            neededChars.put(c, neededChars.getOrDefault(c, 0) + 1);
        }
        
        int conditionCount = neededChars.size();
        
        while (right < m) {
            char rChar = s.charAt(right);
            seenChars.put(rChar, seenChars.getOrDefault(rChar,0) + 1);
            
            if (neededChars.containsKey(rChar) && seenChars.get(rChar).intValue() == neededChars.get(rChar).intValue()) {
                conditionCount--;
            }
            
            while (left <= right && conditionCount == 0) {
                if (subLength == -1 || right - left + 1 < subLength) {
                    minLeft = left;
                    minRight = right + 1;
                    subLength = minRight - minLeft;
                }
                
                char lChar = s.charAt(left);
                seenChars.put(lChar, seenChars.get(lChar) - 1);
                if (seenChars.get(lChar) < neededChars.getOrDefault(lChar, 0)) {
                    conditionCount++;
                }
                ++left;
            }
            ++right;
        }
        
        return subLength == -1 ? "" : s.substring(minLeft, minRight);
    }
}