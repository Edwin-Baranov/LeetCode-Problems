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
    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode(), dummyMore = new ListNode();
        ListNode pointerLess = dummyLess, pointerMore = dummyMore;
        
        ListNode current = head;
        
        while (current != null) {
            if (current.val < x) {
                pointerLess.next = current;
                pointerLess = current;
            } else {
                pointerMore.next = current;
                pointerMore = current;
            }
            
            
            current = current.next;
        }
        pointerMore.next = null;
        pointerLess.next = dummyMore.next;
        
        return dummyLess.next;
    }
}