class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 1, right = 1;
        int n = nums.length;
        
        while (right < n) {
            if (nums[right] == nums[right-1]) {
                right++;
                continue;
            }
            
            if (nums[left] <= nums[left-1]) {
                nums[left++] = nums[right];
            } else {
                left++;
            }
            right++;
        }
        return left;
    }
}