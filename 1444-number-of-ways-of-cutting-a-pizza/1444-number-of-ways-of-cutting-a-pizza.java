class Solution {
    public int ways(String[] pizza, int k) {
        int rows = pizza.length, cols = pizza[0].length();
        int appleCount[][] = new int[rows + 1][cols + 1];
        int dp[][][] = new int[k][rows][cols];
        
        //Populate the appleCount by grabing the apple state value from pizza for specified space
        //and adding both area values for the under and the right while deleting an overlap
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                appleCount[row][col] =
                    (pizza[row].charAt(col) == 'A' ? 1 : 0) +   //apple state
                    appleCount[row + 1][col] +                  //under area value
                    appleCount[row][col + 1] -                  //right area value
                    appleCount[row + 1][col + 1];               //overlap area value
                
                //Record if designated area contains any apples based on number cuts
                dp[0][row][col] = appleCount[row][col] > 0 ? 1 : 0;
            }
        }
        
        int mod = 1000000007;
        
        for (int remain = 1; remain < k; remain++) {
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    for (int next_row = row + 1; next_row < rows; next_row++) {
                        //if the piece I'm loosing contains apples (top)
                        if (appleCount[row][col] - appleCount[next_row][col] > 0) {
                            //count if the pieace I'm keeping has apples or not
                            dp[remain][row][col] += dp[remain - 1][next_row][col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                    for (int next_col = col + 1; next_col < cols; next_col++) {
                        //if the piece I'm loosing contains apples (left)
                        if (appleCount[row][col] - appleCount[row][next_col] > 0) {
                            //count if the piece I'm keeping has apples or not
                            dp[remain][row][col] += dp[remain - 1][row][next_col];
                            dp[remain][row][col] %= mod;
                        }
                    }
                }
            }
        }
        //return count of times I had an apple with the remaining piece after specific number of cuts
        return dp[k - 1][0][0];
    }
}