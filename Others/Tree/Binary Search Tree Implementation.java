// http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation/
import java.util.Stack;
public class BinarySearchTree {
    Node root = null;

    public BinarySearchTree() {}

    public void insert(int data) {
        Node target = new Node(data);
        if(root == null) {
            root = target;
            return;
        }

        Node curr = root, parent = null;
        while(true) {
            parent = curr;
            if(curr.val < target.val) {
                curr = curr.right;
                if(curr == null) {
                    parent.right = target;
                    return;
                }
            } else {
                curr = curr.left;
                if(curr == null) {
                    parent.left = target;
                    return;
                }
            }
        }
    }

    public boolean delete(int data) {
        // find the target node and its parent
        Node curr = root, parent = null;
        boolean isLeftChild = false;
        while(curr.val != data) {
            parent = curr;
            if(curr.val < data) {
                curr = curr.right;
                isLeftChild = false;
            } else {
                curr = curr.left;
                isLeftChild = true;
            }
            if(curr == null) return false;
        }

        // now, we have successfully find the target node
        Node deleteNode = curr;

        // case 1: if the target node has no children
        if(deleteNode.left == null && deleteNode.right == null) {
            if(deleteNode == root) root = null;
            else if(isLeftChild) parent.left = null;
            else parent.right = null;
        }

        // case 2: if the target node has only one children
        else if(deleteNode.right == null) {
            if(deleteNode == root) root = root.left;
            else if(isLeftChild) parent.left = deleteNode.left;
            else parent.right = deleteNode.left;
        } else if(deleteNode.left == null) {
            if(deleteNode == root) root = root.right;
            else if(isLeftChild) parent.left = deleteNode.right;
            else parent.right = deleteNode.right;
        }

        // case 3: if the target node has both left and right children
        else {
            // find deleteNode's successor and the parent of successor
            Node successor = null, successorParent = null;
            curr = curr.right;
            while(curr != null) {
                successorParent = successor;
                successor = curr;
                curr = curr.left;
            }

            // deal with successor
            // if successor is not the right child of deleteNode, we need to concatenate the parent of children of successor
            // note that: successor must do not have left child; ONLY change successorParent's left child
            if(successor != deleteNode.right) {
                successorParent.left = successor.right;
                successor.right = deleteNode.right;
            }
            successor.left = deleteNode.left;

            // deal with deleteNode
            if(deleteNode == root) root = successor;
            else if(isLeftChild) parent.left = successor;
            else parent.right = successor;
        }
        return true;
    }

    public boolean find(int val) {
        Node curr = root;
        while(curr != null) {
            if(curr.val == val) return true;
            else if(curr.val < val) curr = curr.right;
            else curr = curr.left;
        }
        return false;
    }

    public String display() {
        Node curr = root;
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();

        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                sb.append(curr.val).append(" ");
                curr = curr.right;
            }
        }
        return sb.toString();
    }

    class Node {
        public Node left = null, right = null;
        public int val = 0;

        public Node(int val) {
            this.val = val;
        }

        public String toString() {
            return Integer.toString(val);
        }
    }
}