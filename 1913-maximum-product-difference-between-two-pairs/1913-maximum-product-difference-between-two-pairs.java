class Solution {
    public int maxProductDifference(int[] nums) {
        PriorityQueue<Integer> max = new PriorityQueue();
        PriorityQueue<Integer> min = new PriorityQueue(Collections.reverseOrder());
        
        for (int num : nums) {
            addToPriority(max, num);
            addToPriority(min, num);
        }
        
        return (max.poll() * max.poll()) - (min.poll() * min.poll());
    }
    
    private void addToPriority(PriorityQueue<Integer> pQueue, Integer input) {
        pQueue.add(input);
        while (pQueue.size() > 2)
            pQueue.poll();
    }
}