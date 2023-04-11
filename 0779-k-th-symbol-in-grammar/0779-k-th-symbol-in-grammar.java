class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        
        if (k > (int)Math.pow(2, n-2)) {
            //return the inverse of parent
            return ~kthGrammar(n-1, k-(int)Math.pow(2, n-2)) & 1;
        } else {
            return kthGrammar(n-1, k);
        }
    }
}