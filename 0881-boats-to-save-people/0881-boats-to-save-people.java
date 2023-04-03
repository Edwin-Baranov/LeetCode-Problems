class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int left = 0;
        int right = people.length - 1;
        int result = 0;
        
        Arrays.sort(people);
        
        while (left <= right) {
            if (left == right) {
                return ++result;
            }
            
            if (people[right] + people[left] <= limit) {
                ++result;
                ++left;
                --right;
            } else {
                ++result;
                --right;
            }
        }
        return result;
    }
}