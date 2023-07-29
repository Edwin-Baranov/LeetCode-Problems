class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap();
        int[] count = new int[26];
        
        for (String s : strs) {
            Arrays.fill(count, 0);
            for ( char c : s.toCharArray()) {
                ++count[c - 'a'];
            }
            
            StringBuilder sb = new StringBuilder();
            
            for (int i : count) {
                sb.append(i);
                sb.append(',');
            }
            
            
            String key = sb.toString();
            
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList());
            }
            
            groups.get(key).add(s);
        }
        return new ArrayList(groups.values());
    }
}