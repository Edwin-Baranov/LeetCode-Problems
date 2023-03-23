class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
    
        vector<vector<int>> list;
    
        for(int i=0;i<nums.size()-2 && nums[i] <= 0;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = nums.size()-1;
        
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
            
                if (sum < 0) {
                    j++;
                    continue;
                } else if (sum > 0) {
                    k--;
                    continue;
                }
            
                list.push_back({nums[i], nums[j], nums[k]});
                while(j <= nums.size() / 2 && nums[j]==nums[j+1] ) j++;
                while(k >= nums.size() / 2 && nums[k]==nums[k-1]) k--;
                j++;
                k--;
            }
        
        }
        return list;  
    }
};