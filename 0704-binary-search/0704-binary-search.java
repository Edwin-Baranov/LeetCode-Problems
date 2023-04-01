class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int pointer = left + (right - left) / 2;
            if (nums[pointer] == target)
                return pointer;
            
            if (nums[pointer] < target) {
                left = pointer + 1;
            } else {
                right = pointer - 1;
            }            
        }
        return -1;
    }
}