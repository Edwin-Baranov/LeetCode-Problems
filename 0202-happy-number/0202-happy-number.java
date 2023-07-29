class Solution {
    public boolean isHappy(int n) {
        if (n < 0) return false;
        int temp = 0;
        Set<Integer> history = new HashSet();
        
        while (n != 1 && !history.contains(n)) {
            history.add(n);
            while (n != 0) {
                temp += Math.pow(n % 10, 2);
                n /= 10;
            }
        
            n = temp;
            temp = 0;
        }
        
        return n == 1;
    }
}