class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] memo = new boolean[n];
        List<Integer> result = new LinkedList<Integer>();
        
        for (List<Integer> edge : edges) {
            memo[edge.get(1)] = true;
        }
        
        for (int i = 0; i < memo.length; ++i) {
            if (!memo[i])
                result.add(i);
        }
        
        return result;
    }
}