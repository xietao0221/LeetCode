public class Solution {
    public boolean canJump(int[] nums) {
        int anchor = 0;
        for(int i=0; i<nums.length; i++) {
            if(i > anchor) return false;
            anchor = Math.max(anchor, i+nums[i]);
        }
        return true;
    }
}