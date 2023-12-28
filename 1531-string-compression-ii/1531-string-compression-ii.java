class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    private Set<Integer> add = Set.of(1, 9, 99);
    
    public int getLengthOfOptimalCompression(String s, int k) {
        return dp(s, 0, (char) ('a' + 26), 0, k);
    }
    
    private int dp(String s, int index, char lastChar, int lastCharCount, int k) {
        if (k < 0)
            return Integer.MAX_VALUE / 2;
        
        if (index == s.length())
            return 0;
        
        int key = (index << 24) | (lastChar - 'a' << 16) | (lastCharCount << 8) | k;
        
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        int keepChar;
        int deleteChar = dp(s, index + 1, lastChar, lastCharCount, k - 1);
        
        if (s.charAt(index) == lastChar) {
            keepChar = dp(s, index + 1, lastChar, lastCharCount + 1, k) + (add.contains(lastCharCount) ? 1 : 0);
        } else {
            keepChar = dp(s, index + 1, s.charAt(index), 1, k) + 1;
        }
        
        int result = Math.min(keepChar, deleteChar);
        memo.put(key, result);
        
        return result;
    }
}