class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int left = arr[0];
        int right = arr[1];
        int progression = right - left;
        
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - right != progression)
                return false;
            
            right = arr[i];
        }
        return true;
    }
}