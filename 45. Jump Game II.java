public class Solution {
    public int jump(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int end = 0, maxEnd = 0, step = 0, index = 0;
        while(end < nums.length) {
            step++;
            while(index <= end) {
                // index + nums[index] is end point after jumping from this point
                maxEnd = Math.max(maxEnd, index + nums[index]);
                index++;
                if(maxEnd >= nums.length-1) return step;
            }
            
            // if end is not changed, we cannot move forward from this point
            if(end == maxEnd) break;
            end = maxEnd;
        }
        return -1;
    }
}