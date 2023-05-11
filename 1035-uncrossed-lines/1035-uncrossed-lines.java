class Solution {
    private int solve(int[] nums1, int i, int[] nums2, int j, int[][] memo) {
        if (i <= 0 || j <= 0)
            return 0;
        
        if (memo[i][j] != -1)
            return memo[i][j];
        
        if (nums1[i - 1] == nums2[j - 1]) {
            memo[i][j] = 1 + solve(nums1, i - 1, nums2, j - 1, memo);
        } else {
            memo[i][j] = Math.max(solve(nums1, i, nums2, j - 1, memo), solve(nums1, i - 1, nums2, j, memo));
        }
        
        return memo[i][j];
    }
    
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        int[][] memo = new int[n1 + 1][n2 + 1];
        
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(nums1, n1, nums2, n2, memo);
    }
}