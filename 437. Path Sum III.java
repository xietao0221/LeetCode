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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return pathSumHelper(map, root, 0, sum);
    }
    
    private int pathSumHelper(Map<Integer, Integer> map, TreeNode root, int sum, int target) {
        if(root == null) return 0;
        
        sum += root.val;
        int res = map.containsKey(sum - target) ? map.get(sum - target) : 0;
        
        map.put(sum, map.containsKey(sum) ? map.get(sum) + 1 : 1);
        res += pathSumHelper(map, root.left, sum, target) + pathSumHelper(map, root.right, sum, target);
        map.put(sum, map.get(sum) - 1);
        
        return res;
    }
}