class Solution {
    boolean isPossible = true;
    Map<Integer, ArrayList<Integer>> prereqMap = new HashMap();
    Map<Integer, Integer> visited = new HashMap();
    ArrayList<Integer> courseOrder = new ArrayList<>();
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] req : prerequisites) {
            ArrayList<Integer> list = prereqMap.getOrDefault(req[1], new ArrayList<>());
            list.add(req[0]);
            prereqMap.put(req[1], list);
        }
        
        for (int i = 0; i < numCourses; i++) {
            visited.put(i, 0);
        }
        
        for (int i = 0; i < numCourses; i++) {
            if (visited.get(i) == 0)
                dfs(i);
        }
        
        if (!isPossible)
            return new int[0];
        
        int[] result = new int[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            result[i] = courseOrder.get(numCourses - 1 - i);
        }
        
        return result;
    }
    
    private void dfs(int node) {
        if (!isPossible) {
            return;
        }
        
        visited.put(node, 1);
        
        for (Integer neighbor : prereqMap.getOrDefault(node, new ArrayList<Integer>())) {
            int state = visited.get(neighbor);
            if (state == 0) {
                dfs(neighbor);
            } else if (state == 1) {
                isPossible = false;
            }
        }
        
        visited.put(node, 2);
        courseOrder.add(node);
    }
}