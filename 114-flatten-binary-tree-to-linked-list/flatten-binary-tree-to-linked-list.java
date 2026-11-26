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
    public void flatten(TreeNode root) {
        if(root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        preOrder(root, queue);

        TreeNode prev = queue.poll();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            prev.left = null;
            prev.right = curr;
            prev = curr;
        }
        prev.left = null;
        prev.right = null;
    }
    private void preOrder(TreeNode node, Queue<TreeNode> queue){
        if(node == null) return;

        queue.offer(node);
        preOrder(node.left, queue);
        preOrder(node.right, queue);
    }
}