class Solution {
    public int countNicePairs(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        
        int mod = (int) 1e9 + 7;
        Map<Integer, Integer> counter = new HashMap<>();
        int result = 0;
        
        //nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
        //nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - rev(nums[i]);
        }
        
        for (int num : arr) {
            result = (result + counter.getOrDefault(num, 0)) % mod;
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        
        return result;
    }
    
    private int rev(int num) {
        int result = 0;
        
        while (num > 0) {
            result *= 10;
            result += num % 10;
            num /= 10;
        }
        
        return result;
    }
}