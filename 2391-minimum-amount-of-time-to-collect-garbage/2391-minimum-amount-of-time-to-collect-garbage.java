class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        Map<Character, Integer>garbageLastPos = new HashMap<Character, Integer>();
        Map<Character, Integer>garbageCount = new HashMap<Character, Integer>();
        int[] prefixSum = new int[travel.length + 1];
        
        prefixSum[1] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + travel[i];
        }

        for (int i = 0; i < garbage.length; i++) {
            for (char c : garbage[i].toCharArray()) {
                garbageLastPos.put(c, i);
                garbageCount.put(c, garbageCount.getOrDefault(c, 0) + 1);
            }
        }

        String garbageTypes = "MPG";
        int ans = 0;
        for (char c : garbageTypes.toCharArray()) {
            if (garbageCount.containsKey(c)) {
                ans += prefixSum[garbageLastPos.get(c)] + garbageCount.get(c);
            }
        }

        return ans;
    }
}