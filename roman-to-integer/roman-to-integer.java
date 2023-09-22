class Solution {
    public int romanToInt(String s) {
        int n = s.length();
        char prev = s.charAt(0);
        int result = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        for (int i = 1; i < n; i++) {
            char current = s.charAt(i);
            
            if (map.get(prev) < map.get(current)) {
                result -= map.get(prev);
            } else {
                result += map.get(prev);
            }
            
            prev = current;
        }
        
        result += map.get(prev);
        
        return result;
    }
}