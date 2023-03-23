class Solution {
    public String multiply(String num1, String num2) {
    if (num1.equals("0") || num2.equals("0")) {
        return "0";
    }
    
    int n1 = num1.length();
    int n2 = num2.length();
    int[] result = new int[n1 + n2];
    
    for (int i = n1 - 1; i >= 0; i--) {
        int digit1 = num1.charAt(i) - '0';
        for (int j = n2 - 1; j >= 0; j--) {
            int digit2 = num2.charAt(j) - '0';
            int product = digit1 * digit2;
            int pos1 = i + j;
            int pos2 = i + j + 1;
            int sum = product + result[pos2];
            result[pos2] = sum % 10;
            result[pos1] += sum / 10;
        }
    }
    
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
        if (i == 0 && result[i] == 0) {
            continue;
        }
        sb.append(result[i]);
    }
    return sb.toString();
}

}