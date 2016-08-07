public class Solution {
    private List<Integer> subList = new ArrayList<>();
    private List<List<Integer>> list = new ArrayList<>();
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum3Helper(k, n, 1);
        return list;
    }
    
    public void combinationSum3Helper(int k, int n, int start) {
        if(k == 0 && n == 0) {
            list.add(new ArrayList<>(subList));
            return;
        }
        
        for(int i=start; i<=9; i++) {
            // 1. there are not enough elements to be selected 
            // 2. the smallest sum of the next k elements is greater than n
            if((i + k - 1) > 9 || (i * k + k - 1) > n) return;
            
            // add and backtracking
            subList.add(i);
            combinationSum3Helper(k-1, n-i, i+1);
            subList.remove(subList.size() - 1);
        }
    }
}