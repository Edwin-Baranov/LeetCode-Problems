class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        
        int[] answer = new int[spells.length];
        
        for (int i = 0; i < spells.length; ++i) {
            long target = (long) Math.ceil((1.0 * success) / spells[i]);
            
            if (target > potions[potions.length - 1]) {
                answer[i] = 0;
                continue;
            }
            
            int search = binarySearch(potions, target);
            answer[i] = potions.length - search;            
        }
        return answer;
    }
    
    public int binarySearch(int[] arr, long target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}