class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
    
        int leftPointer = 0, rightPointer;
        int result = 0;
    
        for (rightPointer = 0; rightPointer < s.length(); rightPointer++) {
            char rightChar = s.charAt(rightPointer);
            
            while (charSet.contains(rightChar)) {
                char leftChar = s.charAt(leftPointer);
                charSet.remove(leftChar);
                leftPointer++;
            }
            
            charSet.add(rightChar);
            
            result = Math.max(result, charSet.size());
        }
    
        return result;
    }
}