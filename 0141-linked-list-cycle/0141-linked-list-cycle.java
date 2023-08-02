/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        
        ListNode slow = head, fast = slow.next;
        
        while (fast != null && fast.next != null && fast.next.next != null && fast != slow) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return fast == slow;
    }
}