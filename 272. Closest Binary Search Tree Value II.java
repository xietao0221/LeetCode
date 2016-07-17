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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        Stack<Integer> precessors = new Stack<>(), successors = new Stack<>();
        inorderTraversal(root, target, true, precessors);
        inorderTraversal(root, target, false, successors);
        
        // compare
        while(k-- > 0) {
            if(precessors.isEmpty()) {
                res.add(successors.pop());
            } else if(successors.isEmpty()) {
                res.add(precessors.pop());
            } else {
                res.add(Math.abs((double)successors.peek() - target) <= Math.abs((double)precessors.peek() - target) 
                    ? successors.pop() : precessors.pop());
            }
        }
        return res;
    }
    
    // recursive in-order traversal
    public void inorderTraversal(TreeNode root, double target, boolean direction, Stack<Integer> stack) {
        if(root == null) return;
        inorderTraversal(direction ? root.left : root.right, target, direction, stack);
        
        // direction is true: find the next smaller node
        // direction is false: find the next larger node
        // use ">=" on first statement, or "<=" on second statement, to avoid duplicates
        if((direction && (double)root.val >= target) || (!direction && (double)root.val < target)) return;
        stack.push(root.val);
        
        inorderTraversal(direction ? root.right : root.left, target, direction, stack);
    }
}