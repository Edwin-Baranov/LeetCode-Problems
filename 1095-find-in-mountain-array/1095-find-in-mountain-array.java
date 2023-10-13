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
        Map<Integer, Integer> cache = new HashMap<>();
        return binarySearch(target, 0, mountainArr.length() - 1, mountainArr, cache);
    }
    
    private int binarySearch(int target, int left, int right, MountainArray mountainArr, Map<Integer, Integer> cache) {
        if (right < left)
            return -1;
        
        int mid = (right - left) / 2 + left;
        
        int current = cache.getOrDefault(mid, mountainArr.get(mid));
        cache.put(mid, current);
        
        boolean goingUp = true;
        
        if (mid > 0) {
            int neighbor = cache.getOrDefault(mid-1, mountainArr.get(mid-1));
            cache.put(mid-1, neighbor);
            goingUp = neighbor < current;
        }
        
        if (target > current) {
            if (goingUp) {
                return binarySearch(target, mid + 1, right, mountainArr, cache);
            } else {
                return binarySearch(target, left, mid - 1, mountainArr, cache);
            }
            
        } else if (target < current) {
            int lower = binarySearch(target, left, mid - 1, mountainArr, cache);
            if (lower == -1)
                return binarySearch(target, mid + 1, right, mountainArr, cache);
                
            return lower;
        }
        
        int lower = binarySearch(target, left, mid - 1, mountainArr, cache);
        if (lower == -1)
            return mid;
        
        return lower;
    }
}