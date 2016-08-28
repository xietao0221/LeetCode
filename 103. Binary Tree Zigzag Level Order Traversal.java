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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        
        while(!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            List<Integer> tmpRes = new ArrayList<>();
            while(!queue.isEmpty()) {
                root = queue.poll();
                
                if(level % 2 == 1) tmpRes.add(root.val);
                else tmpRes.add(0, root.val);
                
                if(root.left != null) nextQueue.offer(root.left);
                if(root.right != null) nextQueue.offer(root.right);
            }
            res.add(tmpRes);
            queue = nextQueue;
            level++;
        }
        return res;
    }
}