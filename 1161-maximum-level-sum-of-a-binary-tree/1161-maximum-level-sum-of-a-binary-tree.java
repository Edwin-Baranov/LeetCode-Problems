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
    public int maxLevelSum(TreeNode root) {
        int currentLevel = 0;
        int maximal = Integer.MIN_VALUE;
        int maxLevel = 0;
        Queue<TreeNode> currentQueue = new LinkedList<>();
        
        currentQueue.offer(root);
        
        while(!currentQueue.isEmpty()) {
            ++currentLevel;
            int sum = 0;
            
            for(int i = currentQueue.size(); i > 0; --i) {
                TreeNode node = currentQueue.poll();
                sum += node.val;
                
                if(node.left != null) currentQueue.offer(node.left);
                if(node.right != null) currentQueue.offer(node.right);
            }
            
            if (sum > maximal) {
                maximal = sum;
                maxLevel = currentLevel;
            }
        }
        return maxLevel;        
    }
}