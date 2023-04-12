class Solution {
    public int minCost(String colors, int[] neededTime) {
        int answer = 0;
        int length = colors.length();
        
        for (int prev = 0, curr = 1; curr < length; ++curr) {
            if (colors.charAt(prev) == colors.charAt(curr)) {
                if (neededTime[prev] <= neededTime[curr]) {
                    answer += neededTime[prev];
                    prev = curr;
                } else {
                    answer += neededTime[curr];
                }
            } else {
                prev = curr;
            }
        }
        return answer;
    }
}