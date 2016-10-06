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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = new TreeNode(Integer.MIN_VALUE), curr = root, first = null, second = null;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                
                // find the first mis-order number
                if(first == null && prev.val >= curr.val) first = prev;
                // find the last mid-order number
                if(first != null && prev.val >= curr.val) second = curr;
                prev = curr;
                
                curr = curr.right;
            }
        }
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
}

// Recursive Approach
/*
public class Solution {
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE), first = null, second = null;
    
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    
    public void inOrderTraverse(TreeNode root) {
        if(root.left != null) inOrderTraverse(root.left);
        
        // find the first mis-order number
        if(first == null && prev.val >= root.val) first = prev;
        // find the last mis-order number
        if(first != null && prev.val >= root.val) second = root;
        prev = root;
        
        if(root.right != null) inOrderTraverse(root.right);
    }
}
*/