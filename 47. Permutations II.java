// method1: use used[] to avoid duplicates
public class Solution {   
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteUniqueHelper(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    public void permuteUniqueHelper(int[] nums, List<List<Integer>> res, List<Integer> tmpList, boolean[] used) {
        if(tmpList.size() == nums.length) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            // if the current element equals to the previous one, and we don't choose the previous one, continue
            // if we have choose this one, continue (because each round, we iterate the whole array)
            if((i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) || used[i]) continue;
            
            used[i] = true;
            tmpList.add(nums[i]);
            
            permuteUniqueHelper(nums, res, tmpList, used);
            
            // backtracking
            tmpList.remove(tmpList.size() - 1);
            used[i] = false;
        }
    }
}

// method2: use HashSet to avoid duplicates
/*
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;
        list.add(new ArrayList<>(Arrays.asList(nums[0])));
        
        for(int i = 1; i < nums.length; i++) {
            HashSet<List<Integer>> set = new HashSet<>();   
            List<List<Integer>> newList = new ArrayList<>();
            for(int j = 0; j < list.size(); j++) {
                List<Integer> oldList = list.get(j);
                for(int k = 0; k <= i; k++) {
                    List<Integer> subList = new ArrayList<>(oldList);
                    subList.add(k, nums[i]);
                    if(set.add(subList)) newList.add(subList);      //similar to permutation I, use a hashset to prune
                }
            }
            list = newList;
        }
        return list;
    }
}
*/