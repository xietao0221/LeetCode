// Recursive Solution
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        permuteHelper(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }
    
    private void permuteHelper(int[] nums, boolean[] used, List<List<Integer>> res, List<Integer> tmpRes) {
        if(tmpRes.size() == nums.length) {
            res.add(new ArrayList<>(tmpRes));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) continue;
            
            used[i] = true;
            tmpRes.add(nums[i]);
            
            permuteHelper(nums, used, res, tmpRes);
            
            used[i] = false;
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}

// Iterative Solution
/*
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        
        res.add(new ArrayList<>(Arrays.asList(nums[0])));
        for(int i = 1; i < nums.length; i++) {                  // the new element to be added
            List<List<Integer>> newLists = new ArrayList<>();
            for(int j = 0; j < res.size(); j++) {             // how many old list to be modified
                List<Integer> oldList = res.get(j);
                for(int k = 0; k <= i; k++) {                   // for each old list, how many position can be inserted
                    List<Integer> newList = new ArrayList<>(oldList);
                    newList.add(k, nums[i]);
                    newLists.add(newList);
                }
            }
            res = newLists;
        }
        return res;
    }
}
*/