class SmallestInfiniteSet {
    
    private Integer smallest;
    private PriorityQueue<Integer> minHeap;
    private HashSet<Integer> isPresent;

    public SmallestInfiniteSet() {
        smallest = 1;
        minHeap = new PriorityQueue<>();
        isPresent = new HashSet<>();        
    }
    
    public int popSmallest() {
        int result;
        if (!minHeap.isEmpty()) {
            result = minHeap.poll();
            isPresent.remove(result);
        } else {
            result = smallest;
            ++smallest;
        }
        return result;
    }
    
    public void addBack(int num) {
        if (smallest <= num || isPresent.contains(num)) {
            return;
        }
            
        minHeap.add(num);
        isPresent.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */