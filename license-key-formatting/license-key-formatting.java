class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int count = k;
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '-') {
                continue;
            }
            
            if (count <= 0) {
                result.append('-');
                count = k;
            }
            
            result.append(Character.toUpperCase(s.charAt(i)));
            count--;
        }
        
        return result.reverse().toString();
    }
}