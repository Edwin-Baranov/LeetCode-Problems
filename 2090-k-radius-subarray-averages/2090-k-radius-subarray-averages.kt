class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        val windowSize = 2 * k + 1
        val rightIndex = windowSize - 1
        val result = IntArray(nums.size) { -1 }
        
        var leftWindow = 0
        var leftIndex = k
        var sum = 0L
        
        if (windowSize > nums.size) {
            return result
        }
        
        for (i in nums.indices) {
            sum += nums[i]
            
            if (i >= rightIndex) {
                result[leftIndex++] = (sum / windowSize).toInt()
                sum -= nums[leftWindow++]
            }
        }
        
        return result
    }
}
