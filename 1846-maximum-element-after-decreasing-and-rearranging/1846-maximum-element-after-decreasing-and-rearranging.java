class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);        
        int result = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= result + 1)
                result++;
        }
        
        return result;
    }
}