class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int size = Integer.MAX_VALUE;
        int sum = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (sum >= target) {
                size = Math.min(size, right - left + 1);
                sum -= nums[left++];
            }
        }
        
        return size == Integer.MAX_VALUE ? 0 : size;
    }
}