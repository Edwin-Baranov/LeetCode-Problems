class Solution {
    public int maxProductDifference(int[] nums) {
        int big = 0;
        int bigger = 0;
        
        int small = Integer.MAX_VALUE;
        int smaller = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (bigger < num) {
                big = bigger;
                bigger = num;
            } else if (big < num) {
                big = num;
            }
            
            if (smaller > num) {
                small = smaller;
                smaller = num;
            } else if (small > num) {
                small = num;
            }
        }
        
        return big * bigger - small * smaller;
    }
}