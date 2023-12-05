class Solution {
    public int numberOfMatches(int n) {
        if (n == 1)
            return 0;
        
        int half = n/2;
        
        if (n % 2 == 0) {
            return half + numberOfMatches(half);
        } else {
            return half + 1 + numberOfMatches(half);
        }
    }
}