class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i=0;i<nums.length-2 && nums[i] <= 0;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.length-1;
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if (sum < 0) {
                    j++;
                    continue;
                } else if (sum > 0) {
                    k--;
                    continue;
                }
                
                list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                while(j <= nums.length / 2 && nums[j]==nums[j+1] ) j++;
                while(k >= nums.length / 2 && nums[k]==nums[k-1]) k--;
                j++;
                k--;
            }
            
        }
        return list;
    }
}