class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        
        if (words.length != n)
            return false;
        
        Map<String, Integer> indexMap = new HashMap();
        
        for (int i = 0; i < n; i++) {
            String c = pattern.substring(i, i + 1);
            String word = words[i] + " ";
            
            if (!indexMap.containsKey(c)) {
                indexMap.put(c, i);
            }
            
            if (!indexMap.containsKey(word)) {
                indexMap.put(word, i);
            }
            
            if (indexMap.get(c).intValue() != indexMap.get(word).intValue())
                return false;
        }
        return true;
    }
}