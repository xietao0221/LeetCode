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
    public int sumNumbers(TreeNode root) {
        int[] res = new int[1];
        sumNumbersHelper(root, res, 0);
        return res[0];
    }
    
    public void sumNumbersHelper(TreeNode root, int[] res, int curr) {
        if(root == null) return;
        
        curr = 10 * curr + root.val;
        
        if(root.left == null && root.right == null) {
            res[0] += curr;
            return;
        }
        
        sumNumbersHelper(root.left, res, curr);
        sumNumbersHelper(root.right, res, curr);        
    }
}