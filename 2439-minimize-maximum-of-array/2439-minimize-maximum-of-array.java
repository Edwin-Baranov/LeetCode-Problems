class Solution {
    public int minimizeArrayValue(int[] nums) {
        long answer = 0, sum = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            answer = Math.max(answer, (sum + i) / (i + 1));
        }
        
        return (int)answer;
    }
}