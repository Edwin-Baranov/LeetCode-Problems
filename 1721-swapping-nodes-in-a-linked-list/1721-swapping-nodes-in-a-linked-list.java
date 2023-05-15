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
    public ListNode swapNodes(ListNode head, int k) {
        int count = k;
        ListNode target = head;
        ListNode first = head;
        ListNode second = head;
        
        while (count > 1) {
            target = target.next;
            --count;
        }
        
        first = target;
        
        while (target.next != null) {
            target = target.next;
            second = second.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}