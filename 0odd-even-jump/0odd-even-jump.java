class Solution {
    public int oddEvenJumps(int[] arr) {
        int count = 1;
        boolean[] highJump = new boolean[arr.length], lowJump = new boolean[arr.length];
        highJump[arr.length - 1] = lowJump[arr.length - 1] = true;
        
        TreeMap<Integer, Integer> passedIndexes = new TreeMap();
        passedIndexes.put(arr[arr.length - 1], arr.length - 1);
        
        for (int i = arr.length - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer>
                nextLargest = passedIndexes.ceilingEntry(arr[i]),
                nextSmallest = passedIndexes.floorEntry(arr[i]);
            
            if (nextLargest != null) {
                highJump[i] = lowJump[nextLargest.getValue()];
            } else {
                highJump[i] = false;
            }
            
            if (nextSmallest != null) {
                lowJump[i] = highJump[nextSmallest.getValue()];
            } else {
                lowJump[i] = false;
            }
            
            if (highJump[i]) {
                count++;
            }
            passedIndexes.put(arr[i], i);
        }
        return count;
    }
}