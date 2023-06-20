class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        
        int n = nums.length;
        int windowSize = 2 * k + 1;
        int rightIndex = windowSize - 1;
        int[] result = new int[n];
        Arrays.fill(result, -1);
        
        int leftWindow = 0;
        int leftIndex = k;
        long sum = 0L;
        
        if(windowSize > n)
            return result;
        
        for(int i = 0; i < n; ++i) {
            sum += nums[i];
            
            if (i >= rightIndex) {
                result[leftIndex++] = (int) (sum / windowSize);
                sum -= nums[leftWindow++];
            }
        }
        
        return result;
    }
}