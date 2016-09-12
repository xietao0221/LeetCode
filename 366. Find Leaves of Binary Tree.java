/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // use level to represent the position in the list
public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        findLeavesHelper(root, res);
        return res;
    }
    
    public int findLeavesHelper(TreeNode root, List<List<Integer>> res) {
        if(root == null) return -1;
        
        // must be max
        int level = 1 + Math.max(findLeavesHelper(root.left, res), findLeavesHelper(root.right, res));
        
        if(level == res.size()) res.add(new ArrayList<>());
        res.get(level).add(root.val);
        
        return level;
    }
}