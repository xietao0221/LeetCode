/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// binary search
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        // count the size of left branch
        int count = countNodes(root.left);
        
        if(count == k - 1) {
            // the size of left branch is k-1, so the current root is the kth smallest
            return root.val;
        } else if(count < k - 1) {
            // the size of left branch is too small, move to root.right, but need to modify the 'k'
            // -1 means subtract the root node; -count means subtract the whole left branch
            return kthSmallest(root.right, k - 1 - count);
        } else {
            // move left and search again
            return kthSmallest(root.left, k);
        }
    }
    
    private int countNodes(TreeNode root) {
        if(root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

// in-order traversal
/*
public class Solution {
    private int count = 0, result = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestHelper(root);
        return result;
    }
    
    public void kthSmallestHelper(TreeNode root) {
        if(root == null) return;
        kthSmallestHelper(root.left);

        if(--count == 0) {
            result = root.val;
            return;
        }
        
        kthSmallestHelper(root.right);
    }
}
*/