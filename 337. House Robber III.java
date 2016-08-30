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
    // opt[i][0]: don't rob the current root, so it's safe to choose max(opt[i-1][0], opt[i-1][1])
    // opt[i][1] means rob the current root, so we can only choose opt[i-1][0]
    public int rob(TreeNode root) {
        int[] res = robDFS(root);
        return Math.max(res[0], res[1]);
    }
    
    public int[] robDFS(TreeNode root) {
        int[] res = new int[2];
        if(root == null) return res;
        
        int[] left = robDFS(root.left);
        int[] right = robDFS(root.right);
        
        // don't rob the current node: max_left(yes, no) + max_right(yes, no)
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        // rob the current node: root.val + left(no) + right(no)
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}