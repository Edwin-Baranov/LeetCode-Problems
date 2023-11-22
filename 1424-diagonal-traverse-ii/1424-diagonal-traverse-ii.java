class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList();
        List<Integer> result = new LinkedList();
        
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()) {
            int[] cord = queue.poll();
            List<Integer> row = nums.get(cord[0]);
            
            result.add(row.get(cord[1]));
            
            if (cord[1] == 0 && cord[0] + 1 < nums.size()) {
                queue.add(new int[]{cord[0]+1, 0});
            }
            
            if (cord[1]+1 < row.size()) {
                queue.add(new int[]{cord[0], cord[1]+1});
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}