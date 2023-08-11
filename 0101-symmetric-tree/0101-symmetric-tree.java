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
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> left = new LinkedList(), right = new LinkedList();
        left.add(root.left);
        right.add(root.right);
        
        while (!left.isEmpty() || !right.isEmpty()) {
            TreeNode leftTree = left.poll(), rightTree = right.poll();
            if (leftTree == null && rightTree == null)
                continue;
            if (leftTree == null || rightTree == null)
                return false;
            
            if (leftTree.val == rightTree.val) {
                left.add(leftTree.left);
                right.add(rightTree.right);
                
                left.add(leftTree.right);
                right.add(rightTree.left);
            } else {
                return false;
            }
        }
        
        return true;
    }
}