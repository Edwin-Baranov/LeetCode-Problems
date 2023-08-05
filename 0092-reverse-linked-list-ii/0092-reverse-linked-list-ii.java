class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // Empty list
        if (head == null) {
            return null;
        }
        
        ListNode current = head, prev = null;
        int position = 1;
        while (position < left) {
            prev = current;
            current = current.next;
            position++;
        }
        
        ListNode start = prev, end = current;

        // Iteratively reverse the nodes until n becomes 0.
        ListNode next = null;
        while (position <= right) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            position++;
        }

        // Adjust the final connections as explained in the algorithm
        if (start != null) {
            start.next = prev;
        } else {
            head = prev;
        }

        end.next = current;
        return head;
    }
}