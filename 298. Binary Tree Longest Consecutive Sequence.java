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
    public int longestConsecutive(TreeNode root) {
        if(root == null) return 0;
        int[] res = new int[1];
        longestConsecutiveHelper(root, root.val, 0, res);
        return res[0];
    }
    
    public void longestConsecutiveHelper(TreeNode root, int target, int count, int[] res) {
        if(root == null) return;
        
        if(root.val == target) count++;
        else count = 1;
        
        res[0] = Math.max(res[0], count);
        longestConsecutiveHelper(root.left, root.val + 1, count, res);
        longestConsecutiveHelper(root.right, root.val + 1, count, res);
    }
}