import java.util.regex.Pattern;
import java.util.regex.Matcher;

class Solution {
    public int myAtoi(String s) {
        int result = 0;
        String regex = "^ *([+-]?\\d+)";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        
        if (matcher.find()) {
            String substring = matcher.group(1);
            boolean isNegative = substring.charAt(0) == '-';
            
            try {
                result = Integer.parseInt(substring);
            } catch (NumberFormatException e) {
                result = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }
        
        return result;
    }
}