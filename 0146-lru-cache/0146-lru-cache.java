class LRUCache {
    int capacity = 0;
    int count = 0;
    HashMap<Integer, Node> map = new HashMap<>();
    DoubleLinkedList list = new DoubleLinkedList();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        
        if (n == null) {
            return -1;
        }
        
        list.updateRecent(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            n.value = value;
            list.updateRecent(n);
            return;
        }
        
        Node newNode = list.add(key, value);
        
        if (count >= capacity) {
            Node removed = list.removeHead();
            map.remove(removed.key);
            map.put(key, newNode);
            return;
        }
        
        ++count;
        map.put(key, newNode);
    }
    
    private class DoubleLinkedList {
        private Node head;
        private Node tail;
        
        public DoubleLinkedList() {
            head = null;
            tail = null;
        }
        
        public Node add (int key, int value) {
            Node newNode = new Node(key, value);
            return add(newNode);
        }
        
        private Node add(Node newNode) {
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            return newNode;
        }
        
        private Node remove(Node targetNode) {
            if (head == null) {
                return null;
            }
            if (targetNode == head) {
                head = targetNode.next;
            } else if (targetNode == tail) {
                tail = targetNode.prev;
            } else {
                targetNode.prev.next = targetNode.next;
                targetNode.next.prev = targetNode.prev;
            }
            return targetNode;
        }
        
        public Node removeHead() {
            return remove(head);
        }
        
        public void updateRecent(Node targetNode) {
            remove(targetNode);
            add(targetNode);
        }
    }
    
    private class Node {

        int value;
        int key;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */