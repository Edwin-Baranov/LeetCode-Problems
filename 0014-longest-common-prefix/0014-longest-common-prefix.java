class Solution {
    public String longestCommonPrefix(String[] strs) {
        String key = strs[0];
        int n = strs.length;
        
        for (int i = 1; i < n; i++) {
            int m = key.length();
            if (m == 0)
                break;
            for (int j = 0; j < m; j++) {
                if (j == strs[i].length() || key.charAt(j) != strs[i].charAt(j)) {
                    key = key.substring(0, j);
                    break;
                }
            }
        }
        return key;
    }
}