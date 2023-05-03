class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>(2);
        answer.add(0, new ArrayList<Integer>());
        answer.add(1, new ArrayList<Integer>());
        
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
                answer.get(0).add(value1);
        }
        
        for (int value2 : numSet2) {
            if (!numSet1.contains(value2))
                answer.get(1).add(value2);
        }
        
        return answer;
    }
}