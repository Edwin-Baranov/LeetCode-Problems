class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reversed = reverse(head, tail);
            head = reversed[0];
            tail = reversed[1];
            prev.next = head;
            tail.next = next;
            prev = tail;
            head = tail.next;
        }
        return dummy.next;
    }

    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode curr = head;
        while (prev != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return new ListNode[]{tail, head};
    }
}