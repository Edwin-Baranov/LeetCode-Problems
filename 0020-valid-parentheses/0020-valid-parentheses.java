class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                case '{':
                case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(')
                        return false;
                    break;
                case '}':
                    if (stack.size() == 0 || stack.pop() != '{')
                        return false;
                    break;
                case ']':
                    if (stack.size() == 0 || stack.pop() != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }
}