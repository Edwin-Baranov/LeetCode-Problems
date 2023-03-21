class Solution {
    public int maxArea(int[] height) {
        int result = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            int currentArea = (right - left) * (Math.min(height[left], height[right]));
            result = Math.max(currentArea, result);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}