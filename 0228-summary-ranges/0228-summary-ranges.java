class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<>();
        
        if (nums.length == 0)
            return result;
        
        int left = 0;
        int right = 0;        
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[right] + 1) {
                writeRange(left, right, nums, result);
                left = i;
                right = i;
            } else {
                right = i;
            }
        }
        
        writeRange(left, right, nums, result);
        
        return result;
    }
    
    private void writeRange(int left, int right, int[] data, List<String> result) {
        if (data[left] == data[right]) {
            result.add(String.valueOf(data[left]));
        } else {
            result.add(data[left] + "->" + data[right]);
        }
    }
}