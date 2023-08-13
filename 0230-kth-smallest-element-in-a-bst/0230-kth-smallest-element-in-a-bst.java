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
    int count;
    int result;
    
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return result;
    }
    
    private void traverse(TreeNode root, int k) {
        if (root == null)
            return;
        
        traverse(root.left, k);
        
        if (count == k)
            return;
        
        if (count == k - 1)
            result = root.val;
        
        count++;
        
        traverse(root.right, k);
    }
}