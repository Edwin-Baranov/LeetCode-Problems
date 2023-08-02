class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
                continue;
            }
            
            if (token.equals("-")) {
                int temp = stack.pop();
                stack.push(stack.pop() - temp);
                continue;
            }
            
            if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
                continue;
            }
            
            if (token.equals("/")) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
                continue;
            }
            
            stack.push(Integer.valueOf(token));
        }
        
        return stack.peek();
    }
}