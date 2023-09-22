class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1;
        int result = 0;
        int index = 0;
        
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }
        
        if (index < n) {
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (s.charAt(index) == '+') {
                index++;
            }
        }
        
        while (index < n) {
            char c = s.charAt(index);
            if (!Character.isDigit(c))
                break;
            
            int digit = c - '0';
            
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result *= 10;
            result += digit;
            index++;
        }
        
        return result * sign;
    }
}