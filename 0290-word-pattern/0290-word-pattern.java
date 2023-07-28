class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();
        String[] words = s.split(" ");
        
        Map<Character, String> charToWord = new HashMap();
        Map<String, Character> wordToChar = new HashMap();
        
        if (words.length != n)
            return false;
        
        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (!charToWord.containsKey(c) && !wordToChar.containsKey(word)) {
                charToWord.put(c, word);
                wordToChar.put(word, c);
            } else {
                if (
                    !charToWord.containsKey(c) ||
                    !wordToChar.containsKey(word) ||
                    !charToWord.get(c).equals(word) ||
                    wordToChar.get(word) != c
                   )
                    return false;
            }
        }
        return true;
    }
}