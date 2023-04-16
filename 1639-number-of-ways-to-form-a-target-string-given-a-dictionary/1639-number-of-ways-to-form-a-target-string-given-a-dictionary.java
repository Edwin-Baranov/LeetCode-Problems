class Solution {
    public int numWays(String[] words, String target) {
        //Numbers of letters in the alphabet
        int alphabet = 26;
        
        int mod = 1000000007;
        //Length of word we need to create. Length of words we are given
        int m = target.length(), k = words[0].length();
        //cashe that counts how may times a specific letter ocures at specific index of given words
        int cnt[][] = new int[alphabet][k];
        //Count all char instances into cashe
        for (int j = 0; j < k; ++j) {
            for (String word : words) {
                ++cnt[word.charAt(j) - 'a'][j];
            }
        }
        
        
        long dp[][] = new long[m + 1][k + 1];
        dp[0][0] = 1;
        //For the number of chars we need to build
        for (int i = 0; i <= m; ++i) {
            //iterate through the length of given words to find char ocurences
            for (int j = 0; j < k; ++j) {
                //if we are looking for a valid char
                if (i < m) {
                    dp[i + 1][j + 1] += cnt[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i + 1][j + 1] %= mod;
                }
                dp[i][j + 1] += dp[i][j];
                dp[i][j + 1] %= mod;
            }
        }
        return (int)dp[m][k];
    }
}