// Iterative Approach
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());         // empty list
        
        // for each old list, add a new element
        int size = res.size(), startIndex = 0;
        for(int i = 0; i < nums.length; i++) {
            
            // if nums contains duplicates, the second/third/fourth duplicates cannot be added from 0
            // they can only be added from the last stop(the previous res.size())
            startIndex = i > 0 && nums[i] == nums[i - 1] ? size : 0;
            size = res.size();
            
            for(int j = startIndex; j < size; j++) {
                List<Integer> curr = new ArrayList<>(res.get(j));
                curr.add(nums[i]);
                res.add(curr);
            }
        }
        return res;
    }
}

// Recursive Approach
/*
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsWithDupHelper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void subsetsWithDupHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        // subset means it does not need contain all elements, so the condition is <= rather than ==
        // and do not return after this statement
        res.add(new ArrayList<>(tmpRes));
        
        for(int i = pos; i < nums.length; i++) {
            if(i > pos && nums[i] == nums[i - 1]) continue;   // avoid duplicates
            tmpRes.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
*/