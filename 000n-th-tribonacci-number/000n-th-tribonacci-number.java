class Solution {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        
        int[] db = new int[3];
        db[1] = db[2] = 1;
        
        for (int i = 3; i <= n; ++i) {
            int temp = db[0] + db[1] + db[2];
            db[0] = db[1];
            db[1] = db[2];
            db[2] = temp;
        }
        
        return db[2];
    }
}