class Solution {
    Map<String,Boolean> mem = new HashMap<>();
    
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length() != s2.length())
            return false;
        String key = s1 + s2;
        if(mem.containsKey(key))
            return mem.get(key);
        
        int n = s1.length();
        for(int i=1; i<n; ++i) {
            boolean solve1 = isScramble(s1.substring(0,i),s2.substring(n-i)) && isScramble(s1.substring(i),s2.substring(0,n-i));
            boolean solve2 = isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i),s2.substring(i));
            
            if(solve1 || solve2) {
                mem.put(key,true);
                return true;
            }
        }
        mem.put(key,false);
        return false;
    }
}