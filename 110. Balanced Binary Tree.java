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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return isBalancedHelper(root) != null;
    }
    
    public Integer isBalancedHelper(TreeNode root) {
        if(root == null) return 0;
        
        Integer leftCount = isBalancedHelper(root.left);
        Integer rightCount = isBalancedHelper(root.right);
        
        if(leftCount == null || rightCount == null || Math.abs(leftCount - rightCount) > 1) {
            return null;
        } else {
            return Math.max(leftCount, rightCount) + 1;
        }
    }
}