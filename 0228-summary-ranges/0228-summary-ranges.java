class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        
        if (nums.length == 0)
            return result;
        
        int left = nums[0];
        int right = nums[0];        
        
        for (int i = 1; i < nums.length; ++i) {
            int current = nums[i];
            if (current > right + 1) {
                result.add(left == right ? Integer.toString(left) : String.format("%d->%d", left, right));
                
                left = current;
                right = current;
            } else {
                right = current;
            }
        }
        
        result.add(left == right ? Integer.toString(left) : String.format("%d->%d", left, right));
        
        return result;
    }
}