class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Store number of incoming requirements for each node
        int[] indegree = new int[numCourses];
        //Store adj outgoing nodes
        List<Integer>[] adj = new List[numCourses];
        
        //Create new ArrayLists for outgoing adj nodes
        for (int i = 0; i < numCourses; ++i) {
            adj[i] = new ArrayList<>();
        }
        
        //Fill data
        for (int[] prerequisite: prerequisites) {
            adj[prerequisite[1]].add(prerequisite[0]);
            ++indegree[prerequisite[0]];
        }
        
        //Create new queue and populate it with all nodes that contain 0 incoming requirements
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        //Process through queue by counting number of nodes we've been through
        //Removing an indegree count to all nodes adjasent to queued node
        int nodesVisited = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ++nodesVisited;
            
            for (int neighbor : adj[node]) {
                --indegree[neighbor];
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        //Once queue is finished we canFinish if we've visited all specified courses
        return nodesVisited == numCourses;
    }
}