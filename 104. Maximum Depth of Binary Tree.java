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
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }
    
    private int maxDepthHelper(TreeNode root, int level) {
        if(root == null) return level;
        return Math.max(maxDepthHelper(root.left, level + 1), maxDepthHelper(root.right, level + 1));
    }
}