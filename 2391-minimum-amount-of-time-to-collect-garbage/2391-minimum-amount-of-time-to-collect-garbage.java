class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        //M, P, G
        Map<Character, Integer> timeNeeded = new HashMap<>();
        Map<Character, Boolean> found = new HashMap<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        
        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                timeNeeded.put(c, timeNeeded.getOrDefault(c, 0) + 1);
                
                if (!found.getOrDefault(c, false)) {
                    found.put(c, true);
                    for (int j = lastIndex.getOrDefault(c, 0); j < i; j++) {
                        timeNeeded.put(c, timeNeeded.get(c) + travel[j]);
                    }
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