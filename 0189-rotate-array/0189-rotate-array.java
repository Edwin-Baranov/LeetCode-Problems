class Solution {
    public void rotate(int[] nums, int k) {
        //Example: nums.length = 5 [0,1,2,3,4]
        //rotate it by 2
        //(4 + 2) % 5 = 6 % 5 = 1
        int n = nums.length;
        if (k % n == 0)
            return;
        
        int[] temp = new int[n];
        
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}