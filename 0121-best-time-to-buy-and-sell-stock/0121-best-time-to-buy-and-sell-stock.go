func maxProfit(prices []int) int {
    low := math.MaxInt64
    maxProf := 0
    
    for _, price := range(prices) {        
        if (low > price) {
            low = price
        }
        
        maxProf = max(maxProf, price - low)
    }
    
    return maxProf
}