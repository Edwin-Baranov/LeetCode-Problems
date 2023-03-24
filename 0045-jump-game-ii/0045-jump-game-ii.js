/**
 * @param {number[]} nums
 * @return {number}
 */
var jump = function(nums) {
    let result = 0;
        
        for (let i = 0, target = 0, maxDistance = nums[0]; i <= target; ++i) {
            if (target >= nums.length - 1) break;
            maxDistance = Math.max(maxDistance, i + nums[i]);
            
            if (i == target) {
                ++result;
                target = maxDistance;
            }
        }
        return result;
};