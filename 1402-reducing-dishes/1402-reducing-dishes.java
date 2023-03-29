class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int sum = 0, max = 0;
        
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            sum += satisfaction[i];
            
            if(sum < 0) break;
            max += sum;
        }
        return max;
    }
}