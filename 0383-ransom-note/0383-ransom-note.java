class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomCount = new HashMap();
        Map<Character, Integer> magazineCount = new HashMap();
        
        for (char c : ransomNote.toCharArray()) {
            ransomCount.put(c, ransomCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : magazine.toCharArray()) {
            magazineCount.put(c, magazineCount.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomCount.keySet()) {
            if (ransomCount.get(c).intValue() > magazineCount.getOrDefault(c,0).intValue()) {
                return false;
            }
        }
        
        return true;        
    }
}