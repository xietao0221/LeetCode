/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// similar to '241. Different Ways to Add Parentheses'
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return generateTreesHelper(1, n);
    }
    
    public List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> res = new ArrayList<>();
        
        // base condition
        if(start > end) {
            res.add(null);                      // this branch is null
            return res;
        }
        
        if(start == end) {
            res.add(new TreeNode(start));       // this branch just have one node
            return res;
        }
        
        // permutation and combination
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = generateTreesHelper(start, i - 1);
            List<TreeNode> rightList = generateTreesHelper(i + 1, end);
            
            for(TreeNode l : leftList) {
                for(TreeNode r : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}