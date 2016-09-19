public class Solution {
    public List<Integer> minPath(TreeNode root) {
        List<Integer> tmpRes = new ArrayList<>(), res = new ArrayList<>();
        int[] sum = new int[]{Integer.MAX_VALUE};
        minPathHelper(root, tmpRes, res, 0, sum);
        return res;
    }

    private void minPathHelper(TreeNode root, List<Integer> tmpRes, List<Integer> res, int tmpSum, int[] sum) {
        if(tmpSum > sum[0]) return;
        if(root == null) {
            if(tmpSum < sum[0]) {
                res.clear();
                res.addAll(tmpRes);
                sum[0] = tmpSum;
            }
            return;
        }

        tmpRes.add(root.val);
        minPathHelper(root.left, tmpRes, res, tmpSum + root.val, sum);
        tmpRes.remove(tmpRes.size() - 1);

        tmpRes.add(root.val);
        minPathHelper(root.right, tmpRes, res, tmpSum + root.val, sum);
        tmpRes.remove(tmpRes.size() - 1);
    }
}