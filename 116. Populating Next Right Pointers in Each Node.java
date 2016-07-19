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
        TreeLinkNode tempRoot = root;
        while(tempRoot != null && tempRoot.left != null) {
            TreeLinkNode curLevel = tempRoot;
            while(curLevel != null) {
                curLevel.left.next = curLevel.right;
                curLevel.right.next = curLevel.next==null ? null : curLevel.next.left;
                curLevel = curLevel.next;
            }
            tempRoot = tempRoot.left;
        }
    }
}