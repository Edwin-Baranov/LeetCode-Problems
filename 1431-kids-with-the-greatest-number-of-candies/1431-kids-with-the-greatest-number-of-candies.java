class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int count : candies) {
            maxCandies = Math.max(count, maxCandies);
        }
        
        List<Boolean>result = new ArrayList<>();
        
        for (int i = 0; i < candies.length; ++i) {
            result.add(candies[i] + extraCandies >= maxCandies);
        }
        
        return result;
    }
}