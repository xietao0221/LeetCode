/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Solution1: use stack to do inorder traversal. It is a universal approach even though it is not BST
// if curr is not null, push it and make it to be its left child;
// otherwise, pop it and make it to be the new poped node's right child
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
                TreeNode newNode = stack.pop();
                if(!found) {
                    if(newNode == p) found = true;
                } else {
                    return newNode;    
                }
                current = newNode.right;
            }
        }
        return null;
    }
}
*/

// solution 2: has to be BST
// if root.val <= p.val: search root.right, and root cannot be p's inorder successor
// if root.val > p.val: search root.left, and root can be p's inorder successor
/*
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode temp = root, result = null;
        while(temp != null) {
            if(temp.val <= p.val) {
                // don't need to save root if go down-right
                temp = temp.right;
            } else {
                // have to save root if go down-left
                // in this case, temp can be p's inorder successor, so store it temporarilly
                result = temp;      
                temp = temp.left;
            }
        }
        return result;
    }
}
*/

// solution 3: has to be BST
/**
 * we always want to find p's closest node and the node's value is larger than p's value.
 * the answer can either be p's parent or the smallest node in p's right branch.
 * so the answer is got in the 'else' block.
 */
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