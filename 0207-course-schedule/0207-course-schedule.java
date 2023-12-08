class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //Make lists of courses that potentialy unlock when index course is compleated
        List<List<Integer>> unlocks = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            unlocks.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            unlocks.get(prerequisite[1]).add(prerequisite[0]);
        }

        boolean[] visit = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, unlocks, visit, inStack)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(int node, List<List<Integer>> unlocks, boolean[] visit, boolean[] inStack) {
        // If the node is already in the stack, we have a cycle.
        if (inStack[node]) {
            return true;
        }
        if (visit[node]) {
            return false;
        }
        // Mark the current node as visited and part of current recursion stack.
        visit[node] = true;
        inStack[node] = true;
        for (int neighbor : unlocks.get(node)) {
            if (dfs(neighbor, unlocks, visit, inStack)) {
                return true;
            }
        }
        // Remove the node from the stack.
        inStack[node] = false;
        return false;
    }
}