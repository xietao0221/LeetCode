/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
          A
        /   \
      B      C
     / \    / \
    D   E  F   G
       / \
      H   I
         / \
        J   K

Pre:    A B D E H I J K C F G
In:     D B H E J I K A F C G
Post:   D H J K I E B F G C A
Pre-Order(left->right) is symmetrical to Post-Order(right->left)

inorder always visits the whole left tree and then visits the top root, so we cares about its range
postorder always visits the top root at the end, so we cares about the last element in postorder
(1) find the top root from the last element in postorder
(2) find the same element in inorder, its position is 'target'; then we know the number of nodes in the right tree.
(3) all elements which is between inStart and 'target' in inorder is the right tree, the rest is the left tree.
(4) As we know the number of nodes in right/left tree, we can modify the range of next search and the val of next right/left tree.
*/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, inorder.length - 1, 0, postorder, postorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart) {
        if(inStart < 0 || inStart < inEnd) return null;
        TreeNode root = new TreeNode(postorder[poStart]);
        
        int target = 0;
        for(int i = inStart; i >= inEnd; i--) {
            if(inorder[i] == postorder[poStart]) {
                target = i;
                break;
            }
        }
        
        root.right = buildTreeHelper(inorder, inStart, target + 1, postorder, poStart - 1);
        root.left = buildTreeHelper(inorder, target - 1, inEnd, postorder, poStart - (inStart - target) - 1);
        return root;
    }
}