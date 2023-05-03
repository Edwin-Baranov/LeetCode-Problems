class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>(2);
        List<Integer> list1 = new LinkedList<Integer>();
        List<Integer> list2 = new LinkedList<Integer>();
        
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> numSet2 = new HashSet<>();
        
        for (int num : nums1) {
            numSet1.add(num);
        }
        
        for (int num : nums2) {
            numSet2.add(num);
        }
        
        for (int value1 : numSet1) {
            if (!numSet2.contains(value1))
                list1.add(value1);
        }
        
        for (int value2 : numSet2) {
            if (!numSet1.contains(value2))
                list2.add(value2);
        }
        
        answer.add(list1);
        answer.add(list2);
        return answer;
    }
}