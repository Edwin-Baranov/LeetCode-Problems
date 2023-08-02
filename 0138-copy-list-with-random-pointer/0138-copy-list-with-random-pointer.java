/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        
        Map<Node, Node> dict = new HashMap<>();
        Node i = head;
        Node result = new Node(i.val);
        dict.put(i, result);
        
        while (i.next != null) {
            Node newNode = new Node(i.next.val);
            dict.get(i).next = newNode;
            i = i.next;
            dict.put(i, newNode);
        }
        
        i = head;
        while (i != null) {
            dict.get(i).random = dict.get(i.random);
            i = i.next;
        }
        
        return result;
    }
}