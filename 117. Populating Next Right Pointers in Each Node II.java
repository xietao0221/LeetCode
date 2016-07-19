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
            TreeLinkNode dummyHead = new TreeLinkNode(0), currChild = dummyHead;
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
            root = dummyHead.next;
        }
    }
}