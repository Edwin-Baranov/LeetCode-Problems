class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int compair = arr[1];
        int progression = compair - arr[0];
        
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - compair != progression)
                return false;
            
            compair = arr[i];
        }
        return true;
    }
}