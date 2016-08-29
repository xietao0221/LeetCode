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
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        
        int[] count = new int[1];
        countUnivalSubtreesHelper(root, count);
        return count[0];
    }
    
    public boolean countUnivalSubtreesHelper(TreeNode root, int[] count) {
        if(root == null) return true;
        
        boolean left = countUnivalSubtreesHelper(root.left, count);
        boolean right = countUnivalSubtreesHelper(root.right, count);
        
        if(left && right) {
            if(root.left != null && root.val != root.left.val) return false;
            if(root.right != null && root.val != root.right.val) return false;
            count[0]++;
            return true;
        } else {
            return false;
        }
    }
}