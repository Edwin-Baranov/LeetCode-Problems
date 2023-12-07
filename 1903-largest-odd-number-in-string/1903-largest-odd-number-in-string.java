class Solution {
    public String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int i;
        
        for (i = chars.length - 1; i >= 0; i--) {
            if ((chars[i] - '0') % 2 == 1)
                break;
        }
        
        return num.substring(0, i+1);
    }
}