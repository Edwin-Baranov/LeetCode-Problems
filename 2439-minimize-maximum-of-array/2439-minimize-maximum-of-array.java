class Solution {
    public int minimizeArrayValue(int[] nums) {
        int answer = 0;
        long sum = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            answer = Math.max(answer, (int)Math.ceil((sum) / (double)(i + 1)));
        }
        
        return answer;
    }
}