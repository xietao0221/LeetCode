public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        // empty list
        res.add(new ArrayList<>());
        // for each old list, add a new element
        for(int num: nums) {
            int size = res.size();
            for(int i=0; i<size; i++) {
                List<Integer> newList = new ArrayList<>(res.get(i));
                newList.add(num);
                res.add(newList);
            }
        }
        return res;
    }
}