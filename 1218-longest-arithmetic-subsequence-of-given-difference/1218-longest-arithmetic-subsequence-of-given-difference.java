class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> mem = new HashMap<>();
        int result = 1;
        
        for (int value : arr) {
            int prev = value - difference;
            if (mem.containsKey(prev)) {
                int count = mem.get(prev) + 1;
                mem.put(value, count);
                result = Math.max(result, count);
            } else {
                mem.put(value, 1);
            }
        }
        return result;
    }
}