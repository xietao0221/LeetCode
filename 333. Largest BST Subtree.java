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
    private int maxSoFar = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if(root == null) return 0;
        
        isValidBSTHelper(root);
        return maxSoFar;
    }
    
    public Wrapper isValidBSTHelper(TreeNode root) {
        if(root == null) return new Wrapper(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        Wrapper left = isValidBSTHelper(root.left);
        Wrapper right = isValidBSTHelper(root.right);
        
        if(left == null || right == null || left.max >= root.val || root.val >= right.min) return null;
        
        int size = left.count + right.count + 1;
        maxSoFar = Math.max(size, maxSoFar);
        // left.min is the min of next root
        // right.max is the max of next root
        return new Wrapper(size, Math.min(root.val, left.min), Math.max(root.val, right.max));
    }
    
    class Wrapper {
        int count, min, max;
        public Wrapper(int count, int min, int max) {
            this.count = count;
            this.min = min;
            this.max = max;
        }
    }
}