/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Recursive Approach
public class Solution {
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = target < (double)root.val ? root.left : root.right;
        if(kid == null) return root.val;
        int kidReturn = closestValue(kid, target);
        return Math.abs((double)kidReturn - target) < Math.abs((double)root.val - target) ? kidReturn : root.val;
    }
}

// Iterative Approach
/*
public class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root != null) {
            if(Math.abs((double)root.val - target) < Math.abs((double)res - target)) res = root.val;
            root = target < (double)root.val ? root.left : root.right;
        }
        return res;
    }
}
*/