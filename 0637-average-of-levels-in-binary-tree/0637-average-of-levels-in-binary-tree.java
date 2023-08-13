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
        Queue<TreeNode> q = new LinkedList();
        List<Double> result = new LinkedList();
        
        q.add(root);
        while (!q.isEmpty()) {
            double sum = 0.0d;
            int count = 0;
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                sum += node.val;
                count++;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            result.add(sum / count);
        }
        
        return result;
    }
}