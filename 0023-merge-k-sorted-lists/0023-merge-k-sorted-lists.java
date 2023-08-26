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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        
        PriorityQueue<ListNode> sorter = new PriorityQueue<>((a,b) -> a.val - b.val);
        
        for (ListNode list : lists) {
            if (list != null)
                sorter.add(list);
        }
        
        int n = sorter.size();
        
        if (n == 0)
            return null;
        
        ListNode dummy = new ListNode();
        ListNode iterator = dummy;
        
        while (sorter.peek() != null) {
            ListNode temp = sorter.poll();
            iterator.next = temp;
            iterator = temp;
            
            if (iterator.next != null)
                sorter.add(iterator.next);
        }
        
        return dummy.next;
    }
}