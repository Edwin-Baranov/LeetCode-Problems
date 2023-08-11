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
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        
        Stack<TreeNode> runnerStack = new Stack<>(), collectorStack = new Stack<>();
        runnerStack.push(root);
        
        int result = 0;
        
        while (!runnerStack.isEmpty()) {
            TreeNode popped = runnerStack.pop();
            if (popped.left != null) collectorStack.push(popped.left);
            if (popped.right != null) collectorStack.push(popped.right);
            
            if (runnerStack.isEmpty()) {
                Stack<TreeNode> temp = runnerStack;
                runnerStack = collectorStack;
                collectorStack = temp;
                result++;
            }
        }
        return result;
    }
}