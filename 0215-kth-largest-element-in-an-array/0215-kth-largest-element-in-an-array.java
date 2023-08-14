class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        int result = 0;
        
        for (int val : nums) {
            pQueue.add(val);
        }
        
        for (int i = 0; i < k; i++) {
            result = pQueue.poll();
        }
        
        return result;
    }
}