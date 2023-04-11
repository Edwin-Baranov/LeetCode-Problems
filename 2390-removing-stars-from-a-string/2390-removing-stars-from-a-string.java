class Solution {
    public String removeStars(String s) {
        StringBuilder result = new StringBuilder();
        int starCount = 0;
        
        for (int i = s.length()-1; i>=0; --i) {
            char ch = s.charAt(i);
            if (ch  == '*'){
                ++starCount;
            } else if (starCount > 0) {
                --starCount;
            } else {
                result.append(ch);
            }
        }
        
        return result.reverse().toString();
    }
}