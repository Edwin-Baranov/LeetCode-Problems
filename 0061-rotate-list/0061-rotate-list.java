class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null|| head.next == null)
            return head;

        // close the linked list into the ring
        ListNode pointer = head;
        int size = 1;
        
        while (pointer.next != null) {
            pointer = pointer.next;
            size++;
        }
        
        k %= size;
        if (k == 0)
            return head;
        
        pointer.next = head;
        
        ListNode new_tail = head;
        
        for (int i = 0; i < size - k - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}