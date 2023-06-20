class Solution {
    fun getAverages(nums: IntArray, k: Int): IntArray {
        if (k == 0) {
            return nums
        }
        
        val subSize = k * 2 + 1
        val leftIndex = k
        val rightIndex = nums.size - k        
        val result = IntArray(nums.size) {-1}
        
        var leftWindow = 0
        var rightWindow = (leftIndex * 2)
        var sum : Long = 0
        
        if (2 * k + 1 > nums.size) {
            return result
        }
        
        for (i in leftWindow until rightWindow + 1) {
            sum += nums[i]
        }
        
        result[leftIndex] = (sum / subSize).toInt()
        
        for (i in leftIndex + 1 until rightIndex) {
            sum -= nums[leftWindow++]
            sum += nums[++rightWindow]
            
            result[i] = (sum / subSize).toInt()
        }
        
        return result
    }
}