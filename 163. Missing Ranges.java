public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int num: nums) {
            if(lower == num - 1) res.add(lower + "");
            else if(lower < num - 1) res.add(lower + "->" + (num - 1));
            lower = num + 1;
        }
        
        if(lower == upper) res.add(lower + "");
        else if(lower < upper) res.add(lower + "->" + upper);
        return res;
    }
}