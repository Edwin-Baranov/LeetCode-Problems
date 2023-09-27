class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        //Sort array so we can start with the negative numbers
        Arrays.sort(nums);
        
        //loop only using non positive numbers
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                Set<Integer> seen = new HashSet<>();
                
                for (int j = i + 1; j < n; j++) {
                    //skip over duplicate numbers
                    
                    int needed = -(nums[i] + nums[j]);
                    
                    //once a needed value is found within the set create a list
                    if (seen.contains(needed)) {
                        result.add(Arrays.asList(nums[i], nums[j], needed));
                        //if combination found skip over nums[j] duplicates
                        while (j + 1 < n && nums[j] == nums[j+1])
                            j++;
                    }
                    seen.add(nums[j]);
                }
            }
        }
        
        return result;
    }
}