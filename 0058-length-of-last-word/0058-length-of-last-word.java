class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = true;
        int n = s.length();
        int count = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (flag == false) {
                    break;
                }
            } else {
                if (flag == true) {
                    flag = false;
                }
                
                count++;
            }
        }
        
        return count;
    }
}