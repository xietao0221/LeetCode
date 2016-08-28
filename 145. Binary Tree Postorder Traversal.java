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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                res.add(0, root.val);
                root = root.right;
            } else {
                root = stack.pop();
                root = root.left;
            }
        }
        return res;
    }
}

// Recursive Approach
/*
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversalHelper(root, res);
        return res;
    }
    
    public void postorderTraversalHelper(TreeNode root, List<Integer> res) {
        if(root == null) return;
        postorderTraversalHelper(root.left, res);
        postorderTraversalHelper(root.right, res);
        res.add(root.val);
    }
}
*/