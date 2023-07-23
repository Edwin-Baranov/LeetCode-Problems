class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        
        int left = 0;
        int right = 0;
        
        while (right < prices.length) {
            result = Math.max(result, prices[right] - prices[left]);
            
            if (prices[right] < prices[left]) {
                left = right;
            }
            
            right++;
        }
        return result;
    }
}