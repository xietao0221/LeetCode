public class Solution {
    private List<Integer> subResult = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0);
        return res;
    }

    public void combinationSum2Helper(int[] candidates, int target, int pos) {
        if(target == 0) {
            res.add(new ArrayList<>(subResult));
            return;
        }
        
        for(int i = pos; i < candidates.length && target >= candidates[i]; i++) {
            // (i > pos) means candidates[i-1] is not added, because when candidates[i] is added
            // you call the dfs() and then i = pos; otherwise you skip the current loop and pos does not change
            if(i > pos && candidates[i] == candidates[i - 1]) continue;       // avoid duplicates
            subResult.add(candidates[i]);
            combinationSum2Helper(candidates, target - candidates[i], i + 1);
            subResult.remove(subResult.size() - 1);
        }
    }
}