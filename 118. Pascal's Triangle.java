public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>();
        for(int i = 0; i < numRows; i++) {
            tmpRes.add(1);
            for(int j = tmpRes.size() - 2; j > 0; j--) {
                tmpRes.set(j, tmpRes.get(j - 1) + tmpRes.get(j));
            }
            res.add(new ArrayList<>(tmpRes));
        }
        return res;
    }
}