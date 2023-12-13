class Solution {
    public String largestPalindromic(String num) {
        int[] counter = new int[10];
        int oddMultiple = -1;
        boolean leadingZero = true;
        
        for (char c : num.toCharArray()) {
            int val = c - '0';
            counter[val]++;
            
            if (val != 0 && counter[val] > 1)
                leadingZero = false;
        }
        
        for (int i = 0; i < 10; i++) {
            if (counter[i] % 2 == 1)
                oddMultiple = i;
        }
        
        StringBuilder result = new StringBuilder();
        
        if (oddMultiple != -1)
            counter[oddMultiple]--;
        
        if (!leadingZero) {
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < counter[i] / 2; j++) {
                    result.append(Character.forDigit(i, 10));
                }
            }
        }
        
        if (oddMultiple != -1)
            result.append(Character.forDigit(oddMultiple, 10));
        
        if (!leadingZero) {
            for (int i = 0; i <= 9; i++) {
                for (int j = 0; j < counter[i] / 2; j++) {
                    result.append(Character.forDigit(i, 10));
                }
            }
        }
        
        return result.length() == 0 ? "0" : result.toString();
    }
}