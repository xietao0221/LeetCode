/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// insert (root.left -> tail) between root and root.right using in-order traversal 
public class Solution {
    private TreeNode tail = null;
    
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        // get the tail node
        if(root.left == null && root.right == null) {
            tail = root;
            return;
        }

        // in-order traversal: do inserting between two recursive calls
        flatten(root.left);
        
        // inserting: root.left -> tail
        if(tail != null) {
            // save the head of second part
            TreeNode temp = root.right;
            // append root.left to root's right branch
            root.right = root.left;
            // cut root and root.left apart
            root.left = null;
            // paste new inserting list and the second part together
            tail.right = temp;
            // after one insertion, restore tail to be null
            tail = null;
        }
        
        flatten(root.right);
    }
}