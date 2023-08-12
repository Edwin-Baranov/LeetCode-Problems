/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode LCA = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        checkIfAncestor(root, p, q);
        return LCA;
    }
    
    private boolean checkIfAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (LCA != null || root == null)
            return false;
        
        int count = 0;
        
        boolean self = (root == p || root == q);
        boolean left = checkIfAncestor(root.left, p, q);
        boolean right = checkIfAncestor(root.right, p, q);
        
        if (self)
            count++;
        if (left)
            count++;
        if (right)
            count++;
        
        if (count == 2) {
            LCA = root;
        }
        
        return self || left || right;
    }
}