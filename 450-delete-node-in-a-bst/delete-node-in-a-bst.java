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
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null) return null;

        if(root.val == key){
            return helper(root);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else{
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

    private TreeNode helper(TreeNode root){
        if(root.left == null) return root.right;
        if(root.right == null) return root.left;

        TreeNode leftChild = root.left;
        TreeNode rightChild = root.right;

        TreeNode leftmostOfRight = rightChild;

        while(leftmostOfRight.left != null){
            leftmostOfRight = leftmostOfRight.left;
        }

        leftmostOfRight.left = leftChild;

        return rightChild;
    }
}




// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         if(root == null) return null;

//         if(key < root.val){
//             root.left = deleteNode(root.left, key);
//         }
//         else if (key > root.val){
//             root.right = deleteNode(root.right, key);
//         }
//         else{
//             // node found
//             if(root.right == null) return root.left;
//             if(root.left == null) return root.right;

//             // node has 2 children
//             TreeNode successor = findMin(root.right);

//             root.val = successor.val;

//             root.right = deleteNode(root.right, successor.val);
//         }
//         return root;
//     }

//     // helper function to delete the target node
//     private TreeNode findMin(TreeNode node){
//        while (node.left != null){
//            node = node.left;
//        }
//        return node;
//     }
// }