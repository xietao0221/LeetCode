public class Solution {
    private List<Integer> subResult = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, 0, false);
        return res;
    }

    public void combinationSum2Helper(int[] candidates, int target, int index, boolean skip) {
        if(target == 0) {
            res.add(new ArrayList<>(subResult));
            return;
        }
        if(target < 0 || index == candidates.length) return;

        // there are 2 conditions: choose current element or not
        // to avoid duplicates: if 2 consecutive elements are the same and we skipped the first one
        // we cannot choose the second neither
        if(!(index > 0 && candidates[index] == candidates[index-1] && skip)) {
            subResult.add(candidates[index]);
            combinationSum2Helper(candidates, target - candidates[index], index + 1, false);
            subResult.remove(subResult.size() - 1); // backtracking after choosing
        }
        combinationSum2Helper(candidates, target, index + 1, true); // no backtracking because no choosing
    }
}