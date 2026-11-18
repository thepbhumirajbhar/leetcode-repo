/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: if list is empty return null
        if(head == null) return null;

        // Base case: if only 1 node, return it as the tree node
        if(head.next == null) return new TreeNode(head.val);


        // Find the mid using the slow and fast pointer
        // 'prev' keeps track of the previous node, to make it easy to split
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
        }
        // 'slow' is now the middle node. Cut the left half from the middle
        if(prev != null) prev.next = null;

        TreeNode root = new TreeNode(slow.val);

        // If head == slow, there are no nodes to the left of root
        root.left = sortedListToBST(head == slow ? null : head);
        root.right = sortedListToBST(slow.next);

        return root;
    }
}