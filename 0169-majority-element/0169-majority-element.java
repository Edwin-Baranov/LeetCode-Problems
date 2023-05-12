class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int majority = n / 2;
        int result = -1;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int value : nums) {
            result = value;
            int count = map.getOrDefault(value, 0) + 1;
            
            if (count > majority)
                break;
            
            map.put(value, count);
        }
        return result;
    }
}