class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        
        if (words.length != n)
            return false;
        
        HashMap indexMap = new HashMap();
        
        for (Integer i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            }
            
            if (!indexMap.containsKey(word)) {
                indexMap.put(word, i);
            }
            
            if (indexMap.get(c) != indexMap.get(word))
                return false;
        }
        return true;
    }
}