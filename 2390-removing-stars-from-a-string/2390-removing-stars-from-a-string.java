class Solution {
    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c  == '*'){
                deque.removeLast();
            } else {
                deque.add(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (Character ch : deque) {
            result.append(ch);
        }
        
        return result.toString();
    }
}