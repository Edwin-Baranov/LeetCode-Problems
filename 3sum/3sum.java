class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        
        for(int i=0;i<nums.length-2;i++){
            int a = nums[i];
            int j=i+1;
            int k = nums.length-1;
            
            while(j<k){
                int sum = a + nums[j] + nums[k];
                
                if (sum < 0){
                    j++;
                }else if (sum > 0){
                    k--;
                }else{
                    result.add(Arrays.asList(a, nums[j], nums[k]));
                    j++;
                    k--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}