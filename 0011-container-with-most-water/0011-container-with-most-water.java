class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int volume = 0;
        
        while (left < right) {
            int leftH = height[left], rightH = height[right];
            volume = Math.max(volume, Math.min(leftH, rightH) * (right - left));
            
            if (leftH < rightH) {
                left++;
            } else {
                right--;
            }
        }
        return volume;
    }
}