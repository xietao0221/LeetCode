public class Solution {
    private Map<String, List<TreeNode>> map = new HashMap<>();
    private int max = 0;
    private String maxStr = null;

    public List<TreeNode> findLargestCommonSubTree(TreeNode root) {
        preorderTraversal(root);
        return map.get(maxStr).size() > 1 ? map.get(maxStr) : null;
    }

    private String preorderTraversal(TreeNode root) {
        if(root == null) return "#";

        String res = 1 + preorderTraversal(root.left) + preorderTraversal(root.right);

        if(!map.containsKey(res)) map.put(res, new ArrayList<>());
        map.get(res).add(root);

        if(res.length() > max && map.get(res).size() > 1) {
            max = res.length();
            maxStr = res;
        }

        return res;
    }
}