class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[][] sorted = new int[n][2]; //[rating, index]
        int[] candy = new int[n];
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            sorted[i][0] = ratings[i];
            sorted[i][1] = i;
        }
        
        Arrays.sort(sorted, (a, b) -> a[0] - b[0]);
        
        for (int[] child : sorted) {
            int index = child[1];
            int rating = child[0];
            int left = 0;
            int right = 0;
            if (index - 1 >= 0 && ratings[index - 1] < rating) {
                left = candy[index - 1];
            }
            
            if (index + 1 < n && ratings[index + 1] < rating) {
                right = candy[index + 1];
            }
            
            candy[index] = Math.max(left, right) + 1;
            result += candy[index];
        }
        
        return result;
    }
}