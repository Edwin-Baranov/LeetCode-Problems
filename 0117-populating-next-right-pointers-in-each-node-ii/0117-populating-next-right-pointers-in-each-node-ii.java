/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> process = new LinkedList();
        Queue<Node> collect = new LinkedList();
        
        if(root == null) return null;
        
        process.add(root);
        
        while (!process.isEmpty()) {
            Node poll = process.poll();
            poll.next = process.peek();
            if(poll.left != null) collect.add(poll.left);
            if(poll.right != null) collect.add(poll.right);
            
            if (process.isEmpty()) {
                Queue temp = collect;
                collect = process;
                process = temp;
            }
        }
        return root;
    }
}