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
    int target;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        return countPath(root, 0);
    }
    
    private boolean countPath(TreeNode root, int count) {
        if (root == null)
            return false;
        
        if (root.left == null && root.right == null) {
            return count + root.val == target;
        }
        
        int sum = count + root.val;
        return countPath(root.left, sum) || countPath(root.right, sum);
    }
}