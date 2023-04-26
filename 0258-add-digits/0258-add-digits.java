class Solution {
    public int addDigits(int num) {
        int result = 0;
        String sNum = Integer.toString(num);
        
        for (int i = 0; i < sNum.length(); ++i) {
            result += sNum.charAt(i) - '0';
        }
        return result < 10 ? result : addDigits(result);
    }
}