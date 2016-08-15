// Iterative Approach
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());     // empty list
        
        // for each old list, add a new element
        for(int i=0; i<nums.length; i++) {
            int size = res.size();
            for(int j=0; j<size; j++) {
                List<Integer> newList = new ArrayList<>(res.get(j));
                newList.add(nums[i]);
                res.add(newList);
            }
        }
        return res;
    }
}

// Recursive Approach
/*
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        subsetsHelper(nums, 0, res, new ArrayList<>());
        return res;
    }
    
    private void subsetsHelper(int[] nums, int pos, List<List<Integer>> res, List<Integer> tmpRes) {
        if(pos <= nums.length) res.add(new ArrayList<>(tmpRes));
        
        for(int i=pos; i<nums.length; i++) {
            tmpRes.add(nums[i]);
            subsetsHelper(nums, i + 1, res, tmpRes);
            tmpRes.remove(tmpRes.size() - 1);
        }
    }
}
*/