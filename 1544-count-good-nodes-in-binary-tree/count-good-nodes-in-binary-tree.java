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
    public int goodNodes(TreeNode root) {
        return helper(root, new ArrayList<>());
    }

    private int helper(TreeNode node, List<Integer> path){
        if(node == null) return 0;

        path.add(node.val);
        int count = 0;

        int isGood = (node.val >= Collections.max(path)) ? 1 : 0;
        int leftGood = helper(node.left, path);
        int rightGood = helper(node.right, path);

        path.remove(path.size() - 1);

        return isGood + leftGood + rightGood;
    }
}