class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> dict = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!dict.containsKey(num)) {
                dict.put(num, i);
                continue;
            }
            
            int index = dict.get(num);
            if (Math.abs(i - index) <= k) {
                return true;
            }
            dict.put(num, i);
        }
        return false;
    }
}