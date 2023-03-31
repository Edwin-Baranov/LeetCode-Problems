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
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                int state = pizza[row].charAt(col) == 'A' ? 1 : 0;
                int down = appleCount[row + 1][col];
                int right = appleCount[row][col + 1];
                int overLap = appleCount[row + 1][col + 1];
                appleCount[row][col] = state + down + right - overLap;
            }
        }

        return recursion(0, 0, k - 1);
    }

    private int recursion(int r, int c, int cutsLeft) {
        if (appleCount[r][c] == 0) return 0;
        if (cutsLeft == 0) return 1;
        if (dp[cutsLeft][r][c] != null) return dp[cutsLeft][r][c];

        long res = 0L;
        for (int nr = r; nr < rows; nr++) {
            if (appleCount[r][c] - appleCount[nr][c] > 0) {
                res += recursion(nr, c, cutsLeft - 1);
            }
        }
        for (int nc = c; nc < cols; nc++) {
            if (appleCount[r][c] - appleCount[r][nc] > 0) {
                res += recursion(r, nc, cutsLeft - 1);
            }
        }
        return dp[cutsLeft][r][c] = (int) (res % mod);
    }
}