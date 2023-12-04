class Solution {
    public String largestGoodInteger(String num) {
        char[] chars = num.toCharArray();
        char currentChar = chars[0];
        int subStart = 0; int subEnd = 0;
        int count = 1;
        String result = "";
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != currentChar || count == 3) {
                currentChar = chars[i];
                count = 1;
                subStart = subEnd = i;
            } else {
                subEnd = i;
                count++;
                
                if (count == 3) {
                    String sub = num.substring(subStart, subEnd + 1);
                    if (result == "" || sub.charAt(0) > result.charAt(0))
                        result = sub;
                }
            }
        }
        
        return result;
    }
}