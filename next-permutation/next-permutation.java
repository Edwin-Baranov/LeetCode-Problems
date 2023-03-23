class Solution {
    public void nextPermutation(int[] nums) {
        int start = nums.length-1;
        int end = nums.length-1;
        
        while(start > 0){
            if(nums[start] > nums[start - 1]){
                reverse(nums, start, end);
                int pivot = start;
                while(pivot <= end && nums[pivot] <= nums[start - 1]){
                    pivot++;
                }
                swap(nums,start - 1, pivot);
                return;
            }
            else{
                start--;
            }
        }
        reverse(nums, 0, end);
    }

    static void swap(int nums[],int x,int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    static void reverse(int nums[],int start,int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}