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
    List<Integer> result;
    
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        
        lookupRight(root, 0);
        return result;
    }
    
    private void lookupRight(TreeNode root, int depth) {
        if (root == null)
            return;
        
        if (result.size() == depth)
            result.add(root.val);
        
        lookupRight(root.right, depth + 1);
        lookupRight(root.left, depth + 1);
    }
}