class Solution {
    
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int totalSum = 0;
        
        for (int num : nums)  {
            totalSum += num;
        }
        
        if (totalSum % k != 0)
            return false;
        
        Arrays.sort(nums);
        
        int target = totalSum / k;
        boolean[] used = new boolean[n];
        
        return canPartition(nums, used, target, k, 0, n - 1);
    }
    
    private boolean canPartition(int[] nums, boolean[] used, int target, int k, int sum, int index) {        
        if (k == 0)
            return true;
        
        if (sum == target)
            return canPartition(nums, used, target, k-1, 0, nums.length - 1);
        
        for (int i = index; i >= 0; i--) {
            if (nums[index] > target)
                return false;
            
            if (!used[i] && sum + nums[i] <= target) {
                used[i] = true;
                
                if (canPartition(nums, used, target, k, sum + nums[i], i - 1))
                    return true;
                    
                used[i] = false;
            }
        }
        
        return false;
    }
}