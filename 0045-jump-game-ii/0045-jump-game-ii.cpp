class Solution {
public:
    int jump(vector<int>& nums) {
        int result = 0;

        for (int i = 0, target = 0, maxDistance = nums[0]; i <= target; ++i) {
            if (target >= nums.size() - 1) break;
            maxDistance = max(maxDistance, i + nums[i]);

            if (i == target) {
                ++result;
                target = maxDistance;
            }
        }
        return result;
    }
};