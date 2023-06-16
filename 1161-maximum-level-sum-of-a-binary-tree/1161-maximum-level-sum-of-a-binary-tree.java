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
        int currentLevel = 1;
        int maximal = Integer.MIN_VALUE;
        int maxLevel = 1;
        Queue<TreeNode> currentQueue = new LinkedList<>();
        Queue<TreeNode> nextQueue = new LinkedList<>();
        
        currentQueue.offer(root);
        
        while(!currentQueue.isEmpty()) {
            
            int sum = 0;
            for(TreeNode node : currentQueue) {
                if (node == null) {
                    continue;
                }
                sum += node.val;
                
                if(node.left != null) nextQueue.offer(node.left);
                if(node.right != null) nextQueue.offer(node.right);
            }
            
            if (sum > maximal) {
                maximal = sum;
                maxLevel = currentLevel;
            }
            
            currentQueue = nextQueue;
            nextQueue = new LinkedList<>();
            ++currentLevel;
        }
        return maxLevel;        
    }
}