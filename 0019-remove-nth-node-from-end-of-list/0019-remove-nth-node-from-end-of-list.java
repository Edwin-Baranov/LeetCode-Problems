/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int index = 0;
        ListNode point = head;
        
        while (point != null) {
            index++;
            point = point.next;
        }
        
        int target = index - (n - 1);
        
        if (target == 1)
            return head.next;
            
        index = 1;
        point = head;
        ListNode prev = null;
        
        while (index < target) {
            prev = point;
            point = point.next;
            index++;
        }
        
        prev.next = point.next;
        
        return head;
    }
}