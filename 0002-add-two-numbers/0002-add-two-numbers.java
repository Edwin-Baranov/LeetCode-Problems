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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int multiplier = 0;
        int carry = 0;
        ListNode result = new ListNode();
        ListNode end = result;
        
        while (l1 != null || l2 != null) {
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            
            carry = value / 10;
            value %= 10;
            
            end.next = new ListNode(value);
            end = end.next;
        }
        
        if (carry > 0) {
            end.next = new ListNode(carry);
        }
        
        return result.next;
    }
}