class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int quarterCount = n / 4;
        int[] targets = {arr[quarterCount], arr[n / 2], arr[3 * n / 4]};
        
        for (int val : targets) {
            if (upperBound(arr, val) - lowerBound(arr, val) > quarterCount)
                return val;
        }
        
        return -1;
    }
    
    private int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}