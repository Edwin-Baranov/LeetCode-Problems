class Solution {
    public String longestPalindrome(String s) {
        Map<Character, List<Integer>> indexes = new HashMap<>();
        
        int left = 0, right = 0;
        
        char[] chars = s.toCharArray();
        
        addCharIndexes(indexes, chars);
        
        for (int i = 0; i < chars.length; i++) {
            List<Integer> indexList = indexes.get(chars[i]);
            
            for (Integer index : indexList) {
                if (index - i <= right - left)
                    break;
                
                if(isPalindrome(chars, i, index)) {
                    left = i;
                    right = index;
                    break;
                }
            }
        }
        
        return s.substring(left, right + 1);
        
        
    }
    
    private boolean isPalindrome(char[] chars, int start, int end) {
        
        while(start < end) {
            if (chars[start] != chars[end])
                return false;
            
            start++;
            end--;
        }
        
        return true;
    }
    
    private void addCharIndexes(Map<Character, List<Integer>> indexes, char[] chars) {
        
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            List<Integer> indexList = indexes.getOrDefault(c, new LinkedList<Integer>());
            indexList.add(i);
            
            indexes.put(c, indexList);
        }
        
        for (List<Integer> indexList : indexes.values()) {
            Collections.sort(indexList, Collections.reverseOrder());
        }
    }
}