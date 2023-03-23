class Solution {
public:
    int maxArea(vector<int>& height) {
        int result = 0;
        int left = 0, right = height.size() - 1;
    
        while (left < right) {
            int currentArea = (right - left) * (min(height[left], height[right]));
            result = max(currentArea, result);
        
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
};