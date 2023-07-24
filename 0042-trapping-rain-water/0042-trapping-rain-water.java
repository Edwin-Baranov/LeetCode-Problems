class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0, maxRight = 0;
        int result = 0;
        
        while (left < right) {            
            if (height[left] < height[right]) {
                maxLeft = Math.max(maxLeft, height[left++]);
                if (height[left] < maxLeft) {
                    result += maxLeft - height[left];
                }
            } else {
                maxRight = Math.max(maxRight, height[right--]);
                if (height[right] < maxRight) {
                    result += maxRight - height[right];
                }
            }
        }
        return result;
    }
}