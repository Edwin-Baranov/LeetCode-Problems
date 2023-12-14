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
        ArrayList<Boolean> used = new ArrayList<>(Collections.nCopies(n, false));
        Map<ArrayList<Boolean>, Boolean> memo = new HashMap<>();
        
        return canPartition(nums, used, memo, target, k, 0, n - 1);
    }
    
    private boolean canPartition(int[] nums, ArrayList<Boolean> used, Map<ArrayList<Boolean>, Boolean> memo, int target, int k, int sum, int index) {        
        if (k == 1)
            return true;
        
        if (memo.containsKey(used))
            return memo.get(used);
        
        if (sum == target) {
            boolean answer = canPartition(nums, used, memo, target, k-1, 0, nums.length - 1);
            memo.put(used, answer);
            return answer;
        }
        
        for (int i = index; i >= 0; i--) {
            if (nums[index] > target)
                return false;
            
            if (!used.get(i) && sum + nums[i] <= target) {
                used.set(i, true);
                
                if (canPartition(nums, used, memo, target, k, sum + nums[i], i - 1))
                    return true;
                    
                used.set(i, false);
            }
        }
        
        memo.put(used, false);
        return false;
    }
}