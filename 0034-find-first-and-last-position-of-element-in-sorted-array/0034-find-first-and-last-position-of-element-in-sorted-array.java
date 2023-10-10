class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(n == 0)
            return new int[]{-1, -1};
        
        int left = 0, right = n - 1;
        int mid = 0;
        
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (nums[mid] == target)
                break;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        if (left > right)
            return new int[]{-1, -1};
        
        int start = mid, end = mid;
        int startRight = mid - 1, endLeft = mid + 1;
        
        while (left <= startRight) {
            mid = (startRight - left) / 2 + left;
            
            if (nums[mid] == target)
                start = mid;
            
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                startRight = mid - 1;
            }
        }
        
        while (endLeft <= right) {
            mid = (right - endLeft) / 2 + endLeft;
            
            if (nums[mid] == target)
                end = mid;
            
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                endLeft = mid + 1;
            }
        }
        
        return new int[]{start, end};        
    }
}