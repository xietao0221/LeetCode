public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if(nums == null || nums.length == 0) return lists;
        
        lists.add(new ArrayList<>(Arrays.asList(nums[0])));
        for(int i=1; i<nums.length; i++) {                  // the new element to be added
            List<List<Integer>> newLists = new ArrayList<>();
            for(int j=0; j<lists.size(); j++) {             // how many old list to be modified
                List<Integer> oldList = lists.get(j);
                for(int k=0; k<=i; k++) {                   // for each old list, how many position can be inserted
                    List<Integer> newList = new ArrayList<>(oldList);
                    newList.add(k, nums[i]);
                    newLists.add(newList);
                }
            }
            lists = newLists;
        }
        return lists;
    }
}