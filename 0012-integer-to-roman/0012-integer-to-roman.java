class Solution {
    static int[] values = {
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };
    
    static String[] symbols = {
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };
    
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            int count = num / values[i];
            num -= count * values[i];
            for (int j = count; j > 0; j--) {
                sb.append(symbols[i]);
            }
        }
        
        return sb.toString();
    }
}