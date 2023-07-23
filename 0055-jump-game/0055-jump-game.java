class Solution {
    public boolean canJump(int[] nums) {
        int canReach = nums.length - 1;
        
        for (int i = canReach; i >= 0; i--) {
            if (i + nums[i] >= canReach) {
                canReach = i;
            }
        }
        
        return canReach == 0;
    }
}