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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        StringBuilder tmpRes = new StringBuilder();
        binaryTreePathsHelper(root, res, tmpRes);
        return res;
    }
    
    public void binaryTreePathsHelper(TreeNode root, List<String> res, StringBuilder tmpRes) {
        if(root == null) return;
        
        int len = tmpRes.length();
        tmpRes.append(root.val);
        
        if(root.left == null && root.right == null) {
            res.add(tmpRes.toString());
        } else {
            tmpRes.append("->");
            binaryTreePathsHelper(root.left, res, tmpRes);
            binaryTreePathsHelper(root.right, res, tmpRes);
        }
        
        tmpRes.setLength(len);
    }
}