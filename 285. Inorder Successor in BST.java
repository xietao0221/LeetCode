/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Has to be BST
// if root.val <= p.val: search root.right, and root cannot be p's inorder successor
// if root.val > p.val: search root.left, and root can be p's inorder successor
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode curr = root, res = null;
        while(curr != null) {
            if(curr.val <= p.val) {
                // don't need to save root if go down-right
                curr = curr.right;
            } else {
                // have to save root if go down-left
                // in this case, curr can be p's inorder successor, so store it temporarilly
                // if curr has no left and no right child, next time curr will be null and break out
                // the res is the final result
                res = curr;
                curr = curr.left;
            }
        }
        return res;
    }
}

// Iterative in-order traversal. It is a universal approach even though it is not BST
/*
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        boolean found = false;
        
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode curr = stack.pop();
                if(!found) {
                    if(curr == p) found = true;
                } else {
                    return curr;
                }
                current = curr.right;
            }
        }
        return null;
    }
}
*/

// Has to be BST
/*
we always want to find p's closest node and the node's value is larger than p's value.
the answer can either be p's parent or the smallest node in p's right branch.
so the answer is got in the 'else' block.
/*
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null) return null;
        
        if(root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            // root is either p's parent or the smallest node in p's right branch
            TreeNode child = inorderSuccessor(root.left, p);
            return child == null ? root : child;
        }
    }
}
*/