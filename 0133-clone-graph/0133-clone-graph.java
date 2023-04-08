/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> visited = new HashMap<>();
        
        if (node == null)
            return null;
        
        return copyNode(node, visited);
    }
    
    private Node copyNode(Node originalNode, Map<Node, Node> visited) {
        if (visited.containsKey(originalNode))
            return visited.get(originalNode);
        
        Node newNode = new Node(originalNode.val);
        visited.put(originalNode, newNode);
        
        for (Node neighbor : originalNode.neighbors) {
            newNode.neighbors.add(copyNode(neighbor, visited));
        }
        return newNode;
    }
}