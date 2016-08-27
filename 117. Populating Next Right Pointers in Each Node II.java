/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null) {
            // level of child
            TreeLinkNode dummy = new TreeLinkNode(0), currChild = dummy;
            while(root != null) {
                if(root.left != null) {
                    currChild.next = root.left;
                    currChild = currChild.next;
                }
                
                if(root.right != null) {
                    currChild.next = root.right;
                    currChild = currChild.next;
                }
                
                root = root.next;
            }
            
            // restore for the next round
            root = dummy.next;
        }
    }
}