/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if some one is null, we cannot compare the value
        if(p == null || q == null) return (p == null && q == null);
        
        // p and q are not null, we could compare their values
        // we need to compare their structure(their left/right children) as well
        if(p.val != q.val || ((p.left == null) != (q.left == null)) || ((p.right == null) != (q.right == null))) {
            return false;
        } else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}