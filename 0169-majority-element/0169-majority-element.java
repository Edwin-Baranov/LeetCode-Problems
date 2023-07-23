class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int result = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            
            count += (nums[i] == result) ? 1 : -1;
        }
        return result;
    }
}