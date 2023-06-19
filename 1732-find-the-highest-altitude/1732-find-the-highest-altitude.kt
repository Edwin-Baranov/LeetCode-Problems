class Solution {
    fun largestAltitude(gain: IntArray): Int {
        var maxAlt = 0
        var currentAlt = 0;
        for (element in gain) {
            currentAlt += element
            maxAlt = Math.max(maxAlt, currentAlt)
        }
        return maxAlt
    }
}