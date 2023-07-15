class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> mem = new HashMap<>();
        int result = 1;
        
        for (int value : arr) {
            int prev = mem.getOrDefault(value - difference, 0);
            mem.put(value, prev + 1);
            result = Math.max(result, mem.get(value));
        }
        return result;
    }
}