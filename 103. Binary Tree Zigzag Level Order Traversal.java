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
        int level = 0;
        
        while(!queue.isEmpty()) {
            List<Integer> tmpRes = new ArrayList<>();
            level++;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode curr = queue.poll();
                
                if(level % 2 == 1) tmpRes.add(curr.val);
                else tmpRes.add(0, curr.val);
                
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            res.add(new ArrayList<>(tmpRes));
        }
        return res;
    }
}