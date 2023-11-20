class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //M, P, G
        Map<Character, Integer> timeNeeded = new HashMap<>();
        Map<Character, Boolean> found = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        int[] prefixSum = new int[travel.length + 1];
        
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }
        
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                timeNeeded.put(c, timeNeeded.getOrDefault(c, 0) + 1);
                
                if (!found.getOrDefault(c, false)) {
                    found.put(c, true);
                    
                    timeNeeded.put(c, timeNeeded.get(c) - prefixSum[lastIndex.getOrDefault(c, 0)] + prefixSum[i]);
                    lastIndex.put(c, i);
                }
            }
            
            found.put('M', false);
            found.put('P', false);
            found.put('G', false);
        }
        
        return timeNeeded.getOrDefault('M', 0) + timeNeeded.getOrDefault('P', 0) + timeNeeded.getOrDefault('G', 0);
    }
}