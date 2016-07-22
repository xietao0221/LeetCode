public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int prev = nums[0], count = 1;
        Boolean increasing = null;
        for(int num: nums) {
            if(num == prev) continue;
            if(increasing == null || increasing != num > prev) {
                increasing = num > prev;
                count++;
            }
            prev = num;
        }
        return count;
    }
}