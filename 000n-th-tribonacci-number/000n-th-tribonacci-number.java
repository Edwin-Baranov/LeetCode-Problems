class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        
        int[] db = new int[n+1];
        db[1] = db[2] = 1;
        
        for (int i = 3; i <= n; ++i) {
            db[i] = db[i-1] + db[i-2] + db[i-3];
        }
        
        return db[n];
    }
}