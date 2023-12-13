class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int totalSum = mean * (n + rolls.length);
        int knownSum = 0;
        
        for (int val : rolls)
            knownSum += val;
        
        int missingSum = totalSum - knownSum;
        double startingVal = (double) missingSum / n;
        double remainderSum = Math.round((startingVal % 1) * n);
        
        if (startingVal > 6 || startingVal < 1 || (remainderSum + (int) startingVal * n) != missingSum)
            return new int[0];
        
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            result[i] = (int) startingVal;
        }
        
        int i = 0;
        while (remainderSum > 0) {
            result[i]++;
            remainderSum--;
            
            if (result[i] == 6)
                i++;
        }
        
        return result;
    }
}