class Solution {
    public int lengthOfLastWord(String s) {
        boolean flag = true;
        int n = s.length();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                flag = true;
            } else if (flag == true){
                flag = false;
                count = 1;
            } else {
                count++;
            }
        }
        
        return count;
    }
}