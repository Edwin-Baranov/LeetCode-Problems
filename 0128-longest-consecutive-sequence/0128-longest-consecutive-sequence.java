class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();        
        for (int num : nums)
            set.add(num);
        
        int result = 0;
        
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int size = 1;
                
                while(set.contains(++current)) {
                    ++size;
                }
                
                result = Math.max(result, size);
            }
        }
        
        return result;
    }
}