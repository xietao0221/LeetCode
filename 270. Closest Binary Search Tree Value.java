/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// given it is the BST, the closest value is got from root and one of its kid(only one)
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = target < (double)root.val ? root.left : root.right;
        if(kid == null) return root.val;
        int kidReturn = closestValue(kid, target);
        return Math.abs((double)kidReturn - target) < Math.abs((double)root.val - target) ? kidReturn : root.val;
    }
}