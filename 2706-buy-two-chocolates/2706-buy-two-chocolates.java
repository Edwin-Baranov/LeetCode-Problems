class Solution {
    public int buyChoco(int[] prices, int money) {
        int result = money;
        int price1 = Integer.MAX_VALUE;
        int price2 = Integer.MAX_VALUE;
        
        for (int price : prices) {
            if (price < price1) {
                price2 = price1;
                price1 = price;
            } else {
                if (price < price2) {
                    price2 = price;
                }
            }
        }
        
        result -= price1 + price2;
        
        return result < 0 ? money : result;
    }
}