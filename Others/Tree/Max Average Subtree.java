public class Solution {
    private double res = 0.0;
    private TreeNode resRoot = null;

    public TreeNode findMaxAveRoot(TreeNode root) {
        findMaxAveRootHelper(root);
        return resRoot;
    }

    private Pair findMaxAveRootHelper(TreeNode root) {
        if(root == null) return null;

        Pair left = findMaxAveRootHelper(root.left);
        Pair right = findMaxAveRootHelper(root.right);

        int leftCount = left == null ? 0 : left.count, rightCount = right == null ? 0 : right.count;
        int leftSum = left == null ? 0 : left.sum, rightSum = right == null ? 0 : right.sum;

        if(leftCount == 0 && rightCount == 0) return new Pair(1, root.val);

        double tmpAve = (double)(leftSum + rightSum) / (double)(leftCount + rightCount);

        if(tmpAve > res) {
            res = tmpAve;
            resRoot = root;
        }
        return new Pair(1 + leftCount + rightCount, root.val + leftSum + rightSum);
    }

    class Pair {
        public int count, sum;
        public Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }
}