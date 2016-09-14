public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if(n == 0 || k == 0) return new ArrayList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmpRes = new ArrayList<>();
        combineHelper(res, tmpRes, 1, n, k);
        return res;
    }
    
    public void combineHelper(List<List<Integer>> res, List<Integer> tmpRes, int start, int end, int count) {
        if(count == 0) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = start; i <= end; i++) {
            tmpRes.add(i);
            combineHelper(res, tmpRes, i + 1, end, count - 1);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}