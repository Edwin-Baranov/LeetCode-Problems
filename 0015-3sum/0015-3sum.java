class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        
        for (int i = 0; i < n - 2 && nums[i] <= 0; i++) {
            int left = i + 1, right = n - 1;
            if (i == 0 || nums[i-1] != nums[i]) {
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];

                    if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[left++], nums[right--]));
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                    }
                }
            }
        }
        return result;
    }
}