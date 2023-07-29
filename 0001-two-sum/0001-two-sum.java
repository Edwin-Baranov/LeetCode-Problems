class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, i);
        }
        
        int[] result = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int key = target - num;
            if (map.containsKey(key)) {
                int index = map.get(key);
                if (i == index) continue;
                result[0] = i;
                result[1] = map.get(target - num);
                break;
            }
        }
        
        return result;
    }
}