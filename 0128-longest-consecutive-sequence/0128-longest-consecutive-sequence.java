class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 1;
        
        Set<Integer> set = new HashSet();
        
        for (int num : nums)
            set.add(num);
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int size = 1;
                
                while(set.contains(++current)) {
                    result = Math.max(result, ++size);
                }
            }
        }
        
        return result;
    }
}