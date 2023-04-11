class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1)
            return 0;
        int halfRowLength = (int)Math.pow(2, n-2);
        
        if (k > halfRowLength) {
            //return the inverse of parent
            return ~kthGrammar(n-1, k-halfRowLength) & 1;
        } else {
            return kthGrammar(n-1, k);
        }
    }
}