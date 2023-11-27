class Solution {
    public int knightDialer(int n) {
        int[][] moves = new int[][]{{4,6},{6,8}, {7,9}, {4,8}, {0,3,9}, {}, {0,1,7}, {2,6}, {1,3}, {2,4}};
        int mod = (int) 1E9 + 7;
        
        int[] memory;
        int[] prevMemory = new int[10];
        Arrays.fill(prevMemory, 1);
        
        for (int i = 1; i < n; i++) {
            memory = new int[10];
            
            for (int digit = 0; digit <= 9; digit++) {
                int count = 0;
                for (int nextMove : moves[digit]) {
                    count += prevMemory[nextMove];
                    count %= mod;
                }
                memory[digit] = count;
            }
            
            prevMemory = memory;
        }
        
        int result = 0;
        
        for (int digit = 0; digit <= 9; digit++) {
            result += prevMemory[digit];
            result %= mod;
        }
        
        return result;
    }
}