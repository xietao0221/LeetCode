/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// the left/right children of lowest level will be swapped first, and then go up until the top root
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        
        TreeNode left = invertTree(root.right), right = invertTree(root.left);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}