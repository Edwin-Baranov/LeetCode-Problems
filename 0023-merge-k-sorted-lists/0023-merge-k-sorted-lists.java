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
        
        ArrayList<ListNode> sorter = new ArrayList<>();
        
        for (ListNode list : lists) {
            ListNode i = list;
            while (i != null) {
                sorter.add(i);
                i = i.next;
            }
        }
        
        int n = sorter.size();
        
        if (n == 0)
            return null;
        
        sorter.sort((a,b) -> a.val - b.val);
        
        for (int i = 1; i < n; i++) {
            sorter.get(i-1).next = sorter.get(i);
        }
        
        sorter.get(n - 1).next = null;
        
        return sorter.get(0);
    }
}