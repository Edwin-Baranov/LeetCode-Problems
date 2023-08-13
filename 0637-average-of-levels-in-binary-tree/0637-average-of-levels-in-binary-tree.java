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
    
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> processing = new LinkedList();
        Queue<TreeNode> collecting = new LinkedList();
        List<Double> result = new LinkedList();
        
        processing.add(root);
        
        double sum = 0.0d;
        int count = 0;
        while (!processing.isEmpty()) {
            TreeNode node = processing.poll();
            sum += node.val;
            count++;
            
            if (node.left != null) collecting.add(node.left);
            if (node.right != null)collecting.add(node.right);
            
            if (processing.isEmpty()) {
                sum /= count;
                result.add(sum);
                count = 0;
                sum = 0.0d;
                
                Queue<TreeNode> temp = collecting;
                collecting = processing;
                processing = temp;
            }
        }
        
        return result;
    }
}