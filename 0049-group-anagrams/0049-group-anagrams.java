class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap();
        
        for (String s : strs) {
            char[] stringChars = s.toCharArray();
            Arrays.sort(stringChars);
            String sort = new String(stringChars);
            
            if (!groups.containsKey(sort)) {
                groups.put(sort, new ArrayList());
            }
            
            List<String> group = groups.get(sort);
            group.add(s);
        }
        return new ArrayList<List<String>>(groups.values());
    }
}