/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Iterative Approach
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null) return root;
        
        TreeNode currRoot = root, currLeft = null, currRight = null, nextLeft = root.left, nextRight = root.right;
        root.left = null;
        root.right = null;
        
        while(nextLeft != null) {
            currLeft = nextLeft;
            currRight = nextRight;
            nextLeft = currLeft.left;
            nextRight = currLeft.right;
            
            currLeft.left = currRight;
            currLeft.right = currRoot;
            
            currRoot = currLeft;
        }
        return currLeft;
    }
}

// Recursive Approach
/*
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}
*/