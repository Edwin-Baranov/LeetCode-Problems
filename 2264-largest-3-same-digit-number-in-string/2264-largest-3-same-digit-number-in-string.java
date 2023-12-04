class Solution {
    public String largestGoodInteger(String num) {
        int windowSize = 3;
        
        char[] chars = num.toCharArray();
        char currentChar = chars[0];
        int count = 1;
        char result = '\0';
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currentChar || count == windowSize) {
                if (i > chars.length - windowSize)
                    break;
                
                currentChar = chars[i];
                count = 1;
            } else {
                count++;
                
                if (count == windowSize) {
                    if (currentChar > result)
                        result = currentChar;
                }
            }
        }
        
        if (result == '\0') {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < windowSize; i++) {
                sb.append(result);
            }
            return sb.toString();
        }
    }
}