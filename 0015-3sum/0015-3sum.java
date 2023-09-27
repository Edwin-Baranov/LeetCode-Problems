class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < n-2 && nums[i] <= 0; ++i) {
            if (i != 0 && nums[i-1] == nums[i])
                continue;
            
            int left = i+1, right = n-1;
            
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                    while (left < right && nums[left] == nums[left - 1])
                        ++left;
                    while (left < right && nums[right] == nums[right + 1])
                        --right;
                } else if (sum < 0) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return result;
    }
}