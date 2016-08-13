public class Solution {
    private List<Integer> subResult = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumHelper(candidates, 0, target);
        return result;
    }
    
    public void combinationSumHelper(int[] candidates, int pos, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(subResult));
            return;
        }
        
        for(int i=pos; i<candidates.length && target >= candidates[i]; i++) {
            subResult.add(candidates[i]);
            combinationSumHelper(candidates, i, target - candidates[i]);
            subResult.remove(subResult.size() - 1);
        }
    }
}