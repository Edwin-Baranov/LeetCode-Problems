class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length;
        int[] result = new int[size];
        int p1 = 0, p2 = 0;
        
        for (int i = 0; i < size; i++) {
            if (p1 >= m) {
                result[i] = nums2[p2++];
                continue;
            }
            
            if (p2 >= n) {
                result[i] = nums1[p1++];
                continue;
            }
            
            if (nums1[p1] < nums2[p2]) {
                result[i] = nums1[p1++];
            } else {
                result[i] = nums2[p2++];
            }
        }
        for (int i = 0; i < size; i++) {
            nums1[i] = result[i];
        }
    }
}