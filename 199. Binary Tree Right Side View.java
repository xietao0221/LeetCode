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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            Integer rightVal = null;
            while(!queue.isEmpty()) {
                root = queue.poll();
                rightVal = root.val;
                if(root.left != null) nextQueue.offer(root.left);
                if(root.right != null) nextQueue.offer(root.right);    
            }
            if(rightVal != null) res.add(rightVal);
            queue = nextQueue;
        }
        return res;
    }
}