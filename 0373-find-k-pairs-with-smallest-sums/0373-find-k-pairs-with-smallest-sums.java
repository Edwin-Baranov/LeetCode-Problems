class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] + a[1] - b[0] - b[1]);
        
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            minHeap.offer(new int[]{nums1[i], nums2[0], 0});
        }
        
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int num1 = curr[0];
            int num2 = curr[1];
            int index2 = curr[2];
            result.add(List.of(num1, num2));
            if (index2 + 1 < nums2.length) {
                minHeap.offer(new int[]{num1, nums2[index2 + 1], index2 + 1});
            }
        }
        return result;
    }
}