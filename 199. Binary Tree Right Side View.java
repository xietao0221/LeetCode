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
            int size = queue.size();
            int candidate = 0;
            while(size-- > 0) {
                root = queue.poll();
                candidate = root.val;
                if(root.left != null) queue.offer(root.left);
                if(root.right != null) queue.offer(root.right);    
            }
            res.add(candidate);
        }
        return res;
    }
}