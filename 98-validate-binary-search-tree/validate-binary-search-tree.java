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

/* OPTIMAL */ 
class Solution{
    private TreeNode prev = null;
    
    public boolean isValidBST(TreeNode root){

        if(root == null) return true;

        if(!isValidBST(root.left)) return false;

        if(prev != null && root.val <= prev.val){
            return false;
        }
        prev = root;

        return isValidBST(root.right);
    }
}
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     // Helper function to maintain the minimum and maximum boundaries
//     private boolean checkBST(TreeNode node, long low, long high){
//         if(node == null) return true;

//         /* Node value must be strictly within the allowed range */
//         if(node.val <= low || node.val >= high){
//             return false;
//         }

//         return checkBST(node.left, low, node.val) && checkBST(node.right, node.val, high);
//     } 
// }