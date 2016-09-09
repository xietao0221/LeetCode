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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Integer min = null;
        
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                
                if(min != null && root.val <= min) return false;
                min = root.val;
                
                root = root.right;    
            }
        }
        return true;
    }
}

// Recursive Approach
/*
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }
    
    public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
        if(root == null) return true;
        return (min == null || root.val > min) 
            && (max == null || root.val < max) 
            && isValidBSTHelper(root.left, min, root.val) 
            && isValidBSTHelper(root.right, root.val, max);
    }
}
*/