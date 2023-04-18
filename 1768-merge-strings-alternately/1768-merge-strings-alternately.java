class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int i = 0, j = 0;
        Boolean firstWord = true;
        StringBuilder result = new StringBuilder();
        
        while (i < n && j < m) {
            if (firstWord) {
                result.append(word1.charAt(i));
                ++i;
            } else {
                result.append(word2.charAt(j));
                ++j;
            }
            firstWord = !firstWord;
        }
        
        if (firstWord) {
            result.append(word1.substring(i));
        } else {
            result.append(word2.substring(j));
        }
        
        return result.toString();
    }
}