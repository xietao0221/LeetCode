public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        for(int num: nums) {
            // if num is MIN, num - 1 will be MAX
            if(num == Integer.MIN_VALUE) {
                lower = num + 1;
                continue;
            }
            
            if(lower < num - 1) res.add(lower + "->" + (num - 1));
            else if(lower == num - 1) res.add(lower + "");
            
            lower = num + 1;
        }
        
        // if the last num is MAX, num + 1 will be MIN
        if(lower == Integer.MIN_VALUE) return res;
        
        if(lower == upper) res.add(lower + "");
        else if(lower < upper) res.add(lower + "->" + upper);
        
        return res;
    }
}