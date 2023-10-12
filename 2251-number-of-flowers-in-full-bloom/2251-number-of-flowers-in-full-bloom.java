class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        for (int i = 0; i < n; ++i) {
            starts[i] = flowers[i][0];
            ends[i] = flowers[i][1] + 1;
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        int[] ans = new int[people.length];
        
        for (int index = 0; index < people.length; index++) {
            int person = people[index];
            int i = binarySearch(starts, person);
            int j = binarySearch(ends, person);
            ans[index] = i - j;
        }
        
        return ans;
    }
    
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}