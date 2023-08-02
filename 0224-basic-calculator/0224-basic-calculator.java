class Solution {
    public int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int operand = 0;
        int result = 0;
        int sign = 1;

        for (char ch : s.toCharArray()) {
            
            if (Character.isDigit(ch)) {
                operand = 10 * operand + (ch - '0');

            } else {
                if (ch == '+') {
                    result += sign * operand;
                    sign = 1;
                    operand = 0;

                } else if (ch == '-') {
                    result += sign * operand;
                    sign = -1;
                    operand = 0;

                } else if (ch == '(') {
                    stack.push(result);
                    stack.push(sign);

                    sign = 1;
                    result = 0;

                } else if (ch == ')') {
                    result += sign * operand;
                    result *= stack.pop();
                    result += stack.pop();

                    operand = 0;
                }
            }
        }
        return result + (sign * operand);
    }
}