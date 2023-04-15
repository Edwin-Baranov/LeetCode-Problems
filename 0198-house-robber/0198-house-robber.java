class Solution {
    int[] memo;
    int[] nums;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        this.nums = nums;
        return dp(nums.length-1);
    }
    
    private int dp(int i) {
        if (i == 0) return nums[0];
        if (i == 1) return Math.max(nums[0], nums[1]);
        if (memo[i] == -1) {
            memo[i] = Math.max(dp(i-1), dp(i-2) + nums[i]);
        }
        return memo[i];
    }
}