class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] canReach = new boolean[n];
        canReach[n - 1] = true;
        
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (canReach[i + j] == true) {
                    canReach[i] = true;
                    break;
                }
            }
        }
        
        return canReach[0];
    }
}