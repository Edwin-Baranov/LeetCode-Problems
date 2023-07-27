class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> neededChars = new HashMap();
        List<Pair<Character, Integer>> seenChars = new ArrayList();
        int left = 0, right = 0;
        int minLeft = 0, minRight = 0;
        int subLength = -1;
        int m = s.length();
        
        for (char c : t.toCharArray()) {
            neededChars.put(c, neededChars.getOrDefault(c,0) + 1);
        }
        
        for (int i = 0; i < m; i++) {
            char c = s.charAt(i);
            if (neededChars.containsKey(c)) {
                seenChars.add(new Pair(c, i));
            }
        }
        
        int conditionCount = neededChars.size();
        
        int n = seenChars.size();
        
        while (right < n) {
            char rChar = seenChars.get(right).getKey();
            neededChars.put(rChar, neededChars.get(rChar) - 1);
            
            if (neededChars.get(rChar).intValue() == 0) {
                conditionCount--;
            }
            
            while (left <= right && conditionCount == 0) {
                int leftIndex = seenChars.get(left).getValue();
                int rightIndex = seenChars.get(right).getValue();
                if (subLength == -1 || rightIndex - leftIndex + 1 < subLength) {
                    minLeft = leftIndex;
                    minRight = rightIndex + 1;
                    subLength = minRight - minLeft;
                }
                
                char lChar = seenChars.get(left).getKey();
                neededChars.put(lChar, neededChars.get(lChar) + 1);
                if (neededChars.get(lChar).intValue() > 0) {
                    conditionCount++;
                }
                ++left;
            }
            ++right;
        }
        
        return subLength == -1 ? "" : s.substring(minLeft, minRight);
    }
}