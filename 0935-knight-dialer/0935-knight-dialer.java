class Solution {
    int[][] memory;
    int[][] moves = new int[][]{{4,6},{6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}};
    int mod = (int) 1E9 + 7;
    public int knightDialer(int n) {
        memory = new int[10][n+1];
        int result = 0;
        for (int i = 0; i <= 9; i++) {
            if (i == 5 && n != 1) continue;
            
            result += validNumbers(i, n);
            result %= mod;
            
        }
        
        return result;
    }
    
    private int validNumbers(int keyNumber, int hops) {
        if (hops == 1) return 1;
        
        int mem = memory[keyNumber][hops];
        if (mem != 0) return mem;
        
        int result = 0;
        
        for (int next : moves[keyNumber]) {
            result += validNumbers(next, hops - 1);
            result %= mod;            
        }
        
        memory[keyNumber][hops] = result;
        
        return result;
    }
}