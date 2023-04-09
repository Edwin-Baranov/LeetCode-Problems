class Solution {
  public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        int[] incomingCount = new int[n];

      //Record all relative connections and incoming counts  
      for (int[] edge : edges) {
            neighbors.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
            incomingCount[edge[1]]++;
      }

        int[][] charCount = new int[n][26];
        Queue<Integer> q = new LinkedList<>();

        // Push all the nodes with no incoming edges into the queue.
        for (int i = 0; i < n; ++i) {
            if (incomingCount[i] == 0) {
                q.offer(i);
            }
        }

        int answer = 1, nodesSeen = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            answer = Math.max(answer, ++charCount[node][colors.charAt(node) - 'a']);
            ++nodesSeen;

            if (!neighbors.containsKey(node)) {
                continue;
            }

            //For each connected neighbor update their char history count with the current route count
            //Or if the neighbor's count is already bigger due to a previouse route keep it.
            for (int neighbor : neighbors.get(node)) {
                for (int i = 0; i < 26; i++) {
                    charCount[neighbor][i] = Math.max(charCount[neighbor][i], charCount[node][i]);
                }

                --incomingCount[neighbor];
                if (incomingCount[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return nodesSeen < n ? -1 : answer;
    }
}