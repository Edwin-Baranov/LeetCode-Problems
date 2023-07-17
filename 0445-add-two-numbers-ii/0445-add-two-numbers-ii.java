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
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        
        for (ListNode i = l1; i != null; i = i.next) {
            s1.add(i.val);
        }
        
        for (ListNode i = l2; i != null; i = i.next) {
            s2.add(i.val);
        }
        
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = 0;
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            sum += carry;
            
            sumStack.add(sum % 10);
            carry = sum / 10;
        }
        
        ListNode result = new ListNode(sumStack.pop());
        ListNode end = result;
        
        while (!sumStack.isEmpty()) {
            end.next = new ListNode(sumStack.pop());
            end = end.next;
        }
        
        return result;
    }
}