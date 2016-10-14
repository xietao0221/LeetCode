// naive backtracking
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

// https://discuss.leetcode.com/topic/55566/going-from-inefficient-recursive-solution-200ms-to-efficient-recursive-solution-2-ms-good-inline-comments-to-make-you-think
// no base case
/*
public class Solution {
    private List<Integer> tmpRes = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        getFactorsHelper(2, n);
        return res;
    }
    
    public void getFactorsHelper(int start, int n) {
        for(int i = start; i <= (int)Math.sqrt(n); i++) {
            if(n % i == 0) {
                tmpRes.add(i);
                List<Integer> tmp = new ArrayList<>(tmpRes);
                tmp.add(n / i);
                res.add(tmp);
                getFactorsHelper(i, n / i);
                tmpRes.remove(tmpRes.size() - 1);
            }
        }
    }
}
*/