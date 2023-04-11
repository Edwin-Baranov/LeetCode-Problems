class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c  == '*'){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
        String result = "";
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        
        return new StringBuilder(result).reverse().toString();
    }
}