class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int cost = 0;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (i < n && colors.charAt(i) == colors.charAt(j)) {
                if (neededTime[j] < neededTime[i]) {
                    cost += neededTime[j];
                    j = i;
                    i++;
                } else {
                    cost += neededTime[i];
                    i++;
                }
            }
        }
        return cost;
    }
}