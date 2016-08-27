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
    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, res);
        return res[0];
    }
    
    public int maxPathSumHelper(TreeNode root, int[] res) {
        if(root == null) return 0;
        
        // negative val could occur, so use Math.max(0, val) to prune this brunch if the val is negative
        int left = Math.max(0, maxPathSumHelper(root.left, res));
        int right = Math.max(0, maxPathSumHelper(root.right, res));
        
        // regard this root as the potential result, so use two branch and one root
        res[0] = Math.max(res[0], left + right + root.val);
        
        // we could only return one branch to the upper layer, so use max(left, right) + root.val
        return root.val + Math.max(left, right);
    }
}