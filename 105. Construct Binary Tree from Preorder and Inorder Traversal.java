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

preorder always visits the current top root first, so we cares about the first element in preorder
inorder always visits the whole left tree and then visits the top root, so we cares about its range
(1) find the top root from the first element in preorder
(2) find the same element in inorder, its position is 'target'; then we know the number of nodes in the left tree.
(3) all elements which is between inStart and 'target' in inorder is the left tree, the rest is the right tree.
(4) As we know the number of nodes in left/right tree, we can modify the range of next search and the val of next left/right tree.
*/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, 0, inorder, 0, inorder.length - 1);
    }
    
    public TreeNode buildTreeHelper(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if(inStart < 0 || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int target = 0;
        for(int i=inStart; i<=inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                target = i;
                break;
            }
        }
        
        root.left = buildTreeHelper(preorder, preStart + 1, inorder, inStart, target - 1);
        root.right = buildTreeHelper(preorder, preStart + (target - inStart) + 1, inorder, target + 1, inEnd);
        return root;
    }
}