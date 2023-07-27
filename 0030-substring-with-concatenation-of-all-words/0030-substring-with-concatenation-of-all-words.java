class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordFrequency = new HashMap();
        List<Integer> result = new ArrayList();
        
        for (String word : words) {
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        int wordLength = words[0].length();
        int substringLength = wordLength * words.length;
        int end = s.length() - wordLength;
        
        for (int i = 0; i < wordLength; i++) {
            Map<String, Integer> seen = new HashMap();
            int wordsLeft = words.length;
            
            for (int left = i, right = i; right <= end; right += wordLength) {
                String sub = s.substring(right, right + wordLength);
                
                if (!wordFrequency.containsKey(sub)) {
                    left = right + wordLength;
                    seen.clear();
                    wordsLeft = words.length;
                } else {
                    seen.put(sub, seen.getOrDefault(sub, 0) + 1);
                    while (seen.get(sub) > wordFrequency.get(sub)) {
                        String removeWord = s.substring(left, left + wordLength);
                        seen.put(removeWord, seen.get(removeWord) - 1);
                        left += wordLength;
                        ++wordsLeft;
                    }
                    --wordsLeft;
                }
                
                if(wordsLeft == 0) {
                    result.add(left);
                }
            }
        }
        return result;
    }
}