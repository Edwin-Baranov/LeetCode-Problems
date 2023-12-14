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
        Integer mask = 0;
        Map<Integer, Boolean> memo = new HashMap<>();
        
        return canPartition(nums, mask, memo, target, k, 0, n - 1);
    }
    
    private boolean canPartition(int[] nums, Integer mask, Map<Integer, Boolean> memo, int target, int k, int sum, int index) {        
        if (k == 1)
            return true;
        
        if (memo.containsKey(mask))
            return memo.get(mask);
        
        if (sum == target) {
            boolean answer = canPartition(nums, mask, memo, target, k-1, 0, nums.length - 1);
            memo.put(mask, answer);
            return answer;
        }
        
        for (int i = index; i >= 0; i--) {
            if (nums[index] > target)
                return false;
            
            if (((mask >> i) & 1) == 0 && sum + nums[i] <= target) {
                mask = (mask | 1 << i);
                
                if (canPartition(nums, mask, memo, target, k, sum + nums[i], i - 1))
                    return true;
                    
                mask = (mask ^ (1 << i));
            }
        }
        
        memo.put(mask, false);
        return false;
    }
}