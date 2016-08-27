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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null) return count;
                
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return count;
    }
}

// Recursive Approach
/*
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        return minDepthHelper(root, 1);
    }
    
    public int minDepthHelper(TreeNode root, int count) {
        if(root.left == null && root.right == null) return count;
        
        int leftCount = root.left != null ? minDepthHelper(root.left, count + 1) : Integer.MAX_VALUE;
        int rightCount = root.right != null ? minDepthHelper(root.right, count + 1) : Integer.MAX_VALUE;
        return Math.min(leftCount, rightCount);
    }
}
*/