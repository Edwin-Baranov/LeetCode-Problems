class Solution {
    int rows, cols;
    Integer[][][] dp;
    int[][] appleCount;
    int mod = 1000000007;

    public int ways(String[] pizza, int k) {
        this.rows = pizza.length;
        this.cols = pizza[0].length();
        this.dp = new Integer[k][rows][cols];
        this.appleCount = new int[rows + 1][cols + 1];

        //Populate the appleCount by grabing the apple state value from pizza for specified space
        //and adding both area values for the under and the right while deleting an overlap
        for (int row = rows - 1; row >= 0; --row) {
            for (int col = cols - 1; col >= 0; --col) {
                int state = pizza[row].charAt(col) == 'A' ? 1 : 0;
                int down = appleCount[row + 1][col];
                int right = appleCount[row][col + 1];
                int overLap = appleCount[row + 1][col + 1];
                appleCount[row][col] = state + down + right - overLap;
            }
        }

        return recursion(0, 0, k - 1);
    }

    //Record and return the number of times where the remaining piece contained apples
    //at the specified location for both horizontal and vertical cuts with number of cuts left
    private int recursion(int row, int col, int cutsLeft) {
        if (appleCount[row][col] == 0) return 0;
        if (cutsLeft == 0) return 1;
        if (dp[cutsLeft][row][col] != null) return dp[cutsLeft][row][col];

        long res = 0L;
        for (int nextRow = row; nextRow < rows; ++nextRow) {
            if (appleCount[row][col] - appleCount[nextRow][col] > 0) {
                res += recursion(nextRow, col, cutsLeft - 1);
            }
        }
        for (int nextCol = col; nextCol < cols; ++nextCol) {
            if (appleCount[row][col] - appleCount[row][nextCol] > 0) {
                res += recursion(row, nextCol, cutsLeft - 1);
            }
        }
        return dp[cutsLeft][row][col] = (int) (res % mod);
    }
}