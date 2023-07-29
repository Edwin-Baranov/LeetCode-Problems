class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> dict = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!dict.containsKey(num)) {
                List<Integer> indexes = new ArrayList();
                indexes.add(i);
                dict.put(num, indexes);
                continue;
            }
            
            List<Integer> indexes = dict.get(num);
            for (int index : indexes) {
                if (Math.abs(i - index) <= k) {
                    return true;
                }
            }
            indexes.add(i);
        }
        return false;
    }
}