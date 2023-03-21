class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
    
        int leftPointer = 0, rightPointer;
        int result = 0;
    
        for (rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char rightChar = s.charAt(rightPointer);
            charMap.put(rightChar, charMap.getOrDefault(rightChar, 0) + 1);
        
            while(charMap.get(rightChar) > 1) {
                char leftChar = s.charAt(leftPointer);
                charMap.put(leftChar, charMap.get(leftChar) - 1);
                if (charMap.get(leftChar) == 0) charMap.remove(leftChar);
                leftPointer++;
            }
            result = Math.max(result, charMap.size());
        }
    
        return result;
    }
}