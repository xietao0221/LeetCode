/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    private List<Integer> list;
    private int size, index;
    
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            if(curr != null) {
                stack.add(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                list.add(curr.val);
                curr = curr.right;    
            }
        }
        
        size = list.size();
        index = 0;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.index != this.size;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */