class Solution {
    public int removeElement(int[] nums, int val) {
        int slow, fast, count;
        slow = fast = count = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i++) {
            if (nums[fast] == val) {
                ++fast;
            } else {
                nums[slow++] = nums[fast++];
                ++count;
            }
        }
        return count;
    }
}