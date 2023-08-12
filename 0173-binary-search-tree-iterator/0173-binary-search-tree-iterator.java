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
class BSTIterator {
    
    LinkedList<TreeNode> list;
    ListIterator iterator;

    public BSTIterator(TreeNode root) {
        list = new LinkedList<>();
        addToList(root);    
        iterator = list.listIterator();
    }
    
    public int next() {
        return ((TreeNode) iterator.next()).val;
    }
    
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    private void addToList(TreeNode root) {
        if (root == null)
            return;
        
        addToList(root.left);
        list.add(root);
        addToList(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */