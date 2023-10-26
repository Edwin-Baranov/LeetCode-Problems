class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        int mod = 1000000007;
        int n = A.length;
        
        Arrays.sort(A);
        
        long[] dp = new long[n];
        Arrays.fill(dp, 1);

        //Map tree count ref for each value
        Map<Integer, Integer> index = new HashMap();
        for (int i = 0; i < n; ++i)
            index.put(A[i], i);

        //for each value
        //check each lesser value to see
        //if it can be combined with other lesser value to make tree
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < i; ++j) {
                if (A[i] % A[j] == 0) { // A[j] is left child
                    int right = A[i] / A[j];
                    if (index.containsKey(right)) {
                        dp[i] = (dp[i] + dp[j] * dp[index.get(right)]) % mod;
                    }
                }
            }

        long ans = 0;
        for (long x: dp) ans += x;
        return (int) (ans % mod);
    }
}