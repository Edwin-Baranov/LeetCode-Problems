class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        
        for (int val : nums) {
            pQueue.add(val);
            if(pQueue.size() > k) {
                pQueue.remove();
            }
        }
        
        return pQueue.peek();
    }
}