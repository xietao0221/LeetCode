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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if(left == null || right == null) return left == right;
        
        if(left.val == right.val) {
            return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
        } else {
            return false;
        }
    }
}