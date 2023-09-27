public class Solution {
    public void nextPermutation(int[] nums) {
        int p1 = nums.length - 2;
        
        while (p1 >= 0 && nums[p1+1] <= nums[p1]) {
            p1--;
        }
        
        if (p1 >= 0) {
            int p2 = nums.length - 1;
            while (nums[p2] <= nums[p1]) {
                p2--;
            }
            swap(nums, p1, p2);
        }
        reverse(nums, p1 + 1);
    }
    
    private void reverse(int[] nums, int left) {
        int right = nums.length - 1;
        
        while (left < right) {
            swap(nums, left++, right--);
        }
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}