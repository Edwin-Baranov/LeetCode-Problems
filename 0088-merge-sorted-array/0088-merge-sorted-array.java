class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int size = nums1.length;
        int[] copy1 = new int[m];
        int p1 = 0, p2 = 0;
        
        for (int i = 0; i < m; i++) {
            copy1[i] = nums1[i];
        }
        
        for (int i = 0; i < size; i++) {
            if (p2 >= n || (p1 < m && copy1[p1] < nums2[p2])) {
                nums1[i] = copy1[p1++];
            } else {
                nums1[i] = nums2[p2++];
            }
        }
    }
}