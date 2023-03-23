class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int start = nums.size() - 1;
        int end = nums.size() - 1;
    
        while (start > 0) {
            if (nums[start] > nums[start - 1]) {
                reverse(nums.begin() + start, nums.end());
                int pivot = start;
                while (pivot <= end && nums[pivot] <= nums[start - 1]) {
                    pivot++;
                }
                swap(nums[start - 1], nums[pivot]);
                return;
            }
            else {
                start--;
            }
        }
    
        reverse(nums.begin(), nums.end());
    }
};