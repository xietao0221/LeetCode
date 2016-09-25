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

/*
TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        TreeNode p4 = new TreeNode(4);
        TreeNode p5 = new TreeNode(5);
        TreeNode p6 = new TreeNode(6);
        TreeNode p7 = new TreeNode(7);
        TreeNode p8 = new TreeNode(8);
        TreeNode p9 = new TreeNode(9);
        TreeNode p10 = new TreeNode(10);
        TreeNode p11 = new TreeNode(11);
        TreeNode p12 = new TreeNode(12);
        TreeNode p13 = new TreeNode(13);
        TreeNode p14 = new TreeNode(14);
        TreeNode p15 = new TreeNode(15);
        TreeNode p16 = new TreeNode(16);
        TreeNode p17 = new TreeNode(17);

        p1.left = p2;
        p1.right = p3;
        p2.left = p4;
        p2.right = p5;
        p3.left = p6;
        p4.left = p7;
        p5.left = p8;
        p6.left = p9;
        p6.right = p10;
        p7.left = p11;
        p7.right = p12;
        p8.left = p13;
        p8.right = p14;
        p10.left = p15;
        p11.left = p16;
        p14.left = p17;
*/