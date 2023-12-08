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
    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        
        String left = "";
        String right = "";
        
        if (root.left != null) {
            left = "(" + tree2str(root.left) + ")";
            
            if (root.right != null) {
                right = "(" + tree2str(root.right) + ")";
            }
        } else {
            if (root.right != null) {
                left = "()";
                right = "(" + tree2str(root.right) + ")";
            }
        }
        
        return root.val + left + right;
    }
}