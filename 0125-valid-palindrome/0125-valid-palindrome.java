class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[_\\W]", "");
        s = s.toLowerCase();
        
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            
            left++;
            right--;
        }
        
        return true;
    }
}