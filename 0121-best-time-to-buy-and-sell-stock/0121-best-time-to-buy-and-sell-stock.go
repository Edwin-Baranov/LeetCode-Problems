func maxProfit(prices []int) int {
    low := 0
    maxProf := 0
    
    for i, price := range(prices) {
        if (i == 0) {
            low = price
            continue
        }
        
        if (low > price) {
            low = price
        }
        
        maxProf = max(maxProf, price - low)
    }
    
    return maxProf
}