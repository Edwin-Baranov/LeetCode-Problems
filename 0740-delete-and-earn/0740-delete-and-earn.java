class Solution {
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> cache = new HashMap<>();
    
    public int deleteAndEarn(int[] nums) {
        int maxNum = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        
        int temp1 = 0;
        int temp2 = points.getOrDefault(1, 0);
        
        for (int i = 2; i <= maxNum; ++i) {
            int newMax = Math.max(temp2, temp1 + points.getOrDefault(i, 0));
            temp1 = temp2;
            temp2 = newMax;
        }
        
        return temp2;
    }
}