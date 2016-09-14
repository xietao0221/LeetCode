public class Solution {
    private List<Integer> tmpRes = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Helper(k, n, 1);
        return res;
    }
    
    public void combinationSum3Helper(int k, int n, int start) {
        if(k == 0 && n == 0) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            // 1. there are not enough elements to be selected 
            // 2. the smallest sum of the next k elements is greater than n
            if((i + k - 1) > 9 || (i * k + k - 1) > n) return;
            
            tmpRes.add(i);
            combinationSum3Helper(k - 1, n - i, i + 1);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}