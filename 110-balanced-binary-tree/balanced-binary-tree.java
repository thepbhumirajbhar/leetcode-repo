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

//-------------APPROACH 1
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        int leftHeight = helper(root.left);
        int rightHeight = helper(root.right);

        if(Math.abs(leftHeight- rightHeight) > 1) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }


    // Returns the height of a subtree so the balance
    // condition can be checked at the current node.
    private int helper(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}