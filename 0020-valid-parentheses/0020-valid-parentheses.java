class Solution {
    public boolean isValid(String s) {
        Stack<Character> chars = new Stack();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                chars.push(c);
            } else {
                if (chars.isEmpty())
                    return false;
                
                char p = chars.pop();
                if ((c==')' && p!='(')||(c=='}' && p!='{')||(c==']' && p!='['))
                    return false;
            }
        }
        return chars.isEmpty();
    }
}