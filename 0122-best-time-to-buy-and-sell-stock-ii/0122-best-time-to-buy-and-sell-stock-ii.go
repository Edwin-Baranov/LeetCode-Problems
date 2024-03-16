func maxProfit(prices []int) int {
    l := len(prices)
    sell := make([]int, l + 1)
    buy := make([]int, l + 1)
    buy[0] = math.MinInt64
    
    for i := range(prices) {
        sell[i+1] = max(buy[i] + prices[i], sell[i])
        buy[i+1] = max(sell[i] - prices[i], buy[i])
    }
    
    return sell[l]
}