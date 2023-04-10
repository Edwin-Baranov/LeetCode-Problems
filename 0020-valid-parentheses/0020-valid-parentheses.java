class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() == 0)
                    return false;
                char pop = stack.pop();
                if ((pop == '(' && c != ')') || (pop == '{' && c != '}') || (pop == '[' && c != ']'))
                    return false;
            }
        }
        return stack.size() != 0 ? false : true;
    }
}