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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>();
        pathSumHelper(root, sum, res, tmpRes);
        return res;
    }
    
    public void pathSumHelper(TreeNode root, int sum, List<List<Integer>> res, List<Integer> tmpRes) {
        if(root == null) return;
        
        tmpRes.add(root.val);
        if(root.val == sum && root.left == null && root.right == null) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        if(root.left != null) {
            pathSumHelper(root.left, sum-root.val, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
        if(root.right != null) {
            pathSumHelper(root.right, sum-root.val, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}