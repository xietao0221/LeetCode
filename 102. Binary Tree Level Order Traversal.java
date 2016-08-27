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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Queue<TreeNode> nextQueue = new LinkedList<>();
            List<Integer> tmpRes = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                tmpRes.add(curr.val);
                if(curr.left != null) nextQueue.offer(curr.left);
                if(curr.right != null) nextQueue.offer(curr.right);
            }
            res.add(new ArrayList<>(tmpRes));
            queue = nextQueue;
        }
        return res;
    }
}