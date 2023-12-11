class Solution {
    public int findSpecialInteger(int[] arr) {
        int twentyFivePercent = arr.length / 4;
        Map<Integer, Integer> counter = new HashMap<>();
        
        for (int val : arr) {
            int count = counter.getOrDefault(val, 0) + 1;
            if (count > twentyFivePercent)
                return val;
            
            counter.put(val, count);
        }
        
        return -1;
    }
}