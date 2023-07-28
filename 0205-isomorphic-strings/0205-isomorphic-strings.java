class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        Map<Character, Character> sMapping = new HashMap();
        Map<Character, Character> tMapping = new HashMap();
        
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            
            if (!sMapping.containsKey(a)) {
                sMapping.put(a, b);
            }
            
            if (!tMapping.containsKey(b)) {
                tMapping.put(b, a);
            }
            
            if (sMapping.get(a) != b || tMapping.get(b) != a) {
                return false;
            }
        }
        return true;
    }
}