public class Solution {
    private List<Integer> tmpRes = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        getFactorsHelper(2, n);
        return res;
    }
    
    public void getFactorsHelper(int start, int n) {
        if(n == 1) {
            if(tmpRes.size() > 1) res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            if(n % i == 0) {
                tmpRes.add(i);
                getFactorsHelper(i, n / i);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
}