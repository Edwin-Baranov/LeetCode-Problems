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
        int count = 0;
        ListNode target = head;
        ListNode first = head;
        ListNode second = head;
        
        while (target != null) {
            ++count;
            
            if (count == k)
                first = target;
            
            target = target.next;
        }
        
        for (int i = 1; i <= count - k; ++i) {
            second = second.next;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}