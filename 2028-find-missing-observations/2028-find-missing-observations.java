class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownSum = 0;
        
        for (int val : rolls)
            knownSum += val;
        
        int missingSum = mean * (n + rolls.length) - knownSum;
        
        if (missingSum < n || missingSum > n * 6 || missingSum < 1)
            return new int[0];
        
        int[] result = new int[n];
        int startingVal = missingSum / n;
        int remainingVal = missingSum % n;
        
        for (int i = 0; i < n; i++) {
            result[i] = startingVal;
        }
        
        int index = 0;
        for (int i = 0; i < remainingVal; i++) {
            result[index]++;
            
            if (result[index] == 6)
                index++;
        }
        
        return result;
    }
}