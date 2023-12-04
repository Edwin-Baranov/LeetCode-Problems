class Solution {
    public String largestGoodInteger(String num) {
        int windowSize = 3;
        
        char[] chars = num.toCharArray();
        char currentDigit = chars[0];
        int count = 1;
        char result = '\0';

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currentDigit) {
                if (i > chars.length - windowSize)
                    break;
                
                currentDigit = chars[i];
                count = 1;
            } else {
                count++;
            }

            if (count == windowSize && currentDigit > result) {
                result = currentDigit;
            }
        }

        return result == '\0' ? "" : String.valueOf(result).repeat(windowSize);
    }
}