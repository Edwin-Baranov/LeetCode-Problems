/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return binarySearch(target, 0, mountainArr.length() - 1, mountainArr);
    }
    
    private int binarySearch(int target, int left, int right, MountainArray mountainArr) {
        if (right < left)
            return -1;
        
        int mid = (right - left) / 2 + left;
        
        int current = mountainArr.get(mid);
        boolean goingUp = true;
        
        if (mid > 0) {
            goingUp = mountainArr.get(mid-1) < current;
        }
        
        if (target > current) {
            if (goingUp) {
                return binarySearch(target, mid + 1, right, mountainArr);
            } else {
                return binarySearch(target, left, mid - 1, mountainArr);
            }
            
        } else if (target < current) {
            int lower = binarySearch(target, left, mid - 1, mountainArr);
            if (lower == -1)
                return binarySearch(target, mid + 1, right, mountainArr);
                
            return lower;
        }
        
        int lower = binarySearch(target, left, mid - 1, mountainArr);
        if (lower == -1)
            return mid;
        
        return lower;
    }
}