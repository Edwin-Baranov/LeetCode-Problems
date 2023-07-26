class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = 1;
        
        for (; right < n; right++) {
            int sum = numbers[left] + numbers[right];
            while (sum > target) {
                sum = numbers[--left] + numbers[right];
            }
            
            if (sum == target)
                break;
            
            ++left;
        }
        int[] result = {left + 1, right + 1};
        return result;
    }
}