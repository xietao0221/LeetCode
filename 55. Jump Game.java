public class Solution {
    public boolean canJump(int[] nums) {
        int maxEnd = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxEnd) return false;
            maxEnd = Math.max(maxEnd, i + nums[i]);
        }
        return true;
    }
}