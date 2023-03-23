class Solution {
    public boolean canJump(int[] nums) {
        Set<Integer> canReach = new HashSet<>();
        
        canReach.add(nums.length - 1);
        
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 0; j <= nums[i]; j++) {
                if (canReach.contains(i + j)) {
                    canReach.add(i);
                    break;
                }
            }
        }
        
        return canReach.contains(0);
    }
}