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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key == root.val) {
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;
            
            TreeNode deleted = root;
            root = min(root.right);
            root.left = deleted.left;
            root.right = deleteNode(deleted.right, key);
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
    
    private TreeNode min(TreeNode root) {
        while(root.left != null) root = root.left;    
        return root;
    }
}