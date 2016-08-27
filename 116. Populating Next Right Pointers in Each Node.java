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
        while(root != null && root.left != null) {
            TreeLinkNode currRoot = root;
            while(currRoot != null) {
                currRoot.left.next = currRoot.right;
                currRoot.right.next = currRoot.next == null ? null : currRoot.next.left;
                currRoot = currRoot.next;
            }
            root = root.left;
        }
    }
}