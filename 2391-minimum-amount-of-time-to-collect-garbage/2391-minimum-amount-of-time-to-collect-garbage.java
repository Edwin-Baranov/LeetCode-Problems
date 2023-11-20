class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //M, P, G
        Map<Character, Integer> timeNeeded = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[travel.length + 1];
        
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }
        
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                lastIndex.put(c, i);
                timeNeeded.put(c, timeNeeded.getOrDefault(c, 0) + 1);
            }
        }
        
        int result = 0;
        
        for (char c : "MPG".toCharArray()) {
            result += timeNeeded.getOrDefault(c, 0) + prefixSum[lastIndex.getOrDefault(c, 0)];
        }
        
        return result;
    }
}