/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        
        if (root == null)
            return result;
        
        Stack<TreeNode> processor = new Stack();
        Stack<TreeNode> collector = new Stack();
        
        processor.push(root);
        
        boolean leftToRight = true;
        
        while (!processor.isEmpty()) {
            List<Integer> order = new ArrayList();
            
            while (!processor.isEmpty()) {
                TreeNode node = processor.pop();
                order.add(node.val);
                
                if (leftToRight) {
                    if (node.left != null) collector.push(node.left);
                    if (node.right != null) collector.push(node.right);
                } else {
                    if (node.right != null) collector.push(node.right);
                    if (node.left != null) collector.push(node.left);
                }
            }
            
            Stack<TreeNode> temp = collector;
            collector = processor;
            processor = temp;
            
            result.add(order);
            leftToRight = !leftToRight;
        }
        
        return result;
    }
}