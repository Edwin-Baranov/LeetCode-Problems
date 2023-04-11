class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int left = 0;
        int right = nums.length - 1;
        
        int[] result = new int[nums.length];
        
        for (int i = left; i < nums.length; ++i) {
            if (nums[i] < pivot)
                result[left++] = nums[i];
        }
        
        for (int i = right; i >= 0; --i) {
            if (nums[i] > pivot)
                result[right--] = nums[i];
        }
        
        while (left <= right) {
            result[left++] = pivot;
        }
        return result;      
    }
}