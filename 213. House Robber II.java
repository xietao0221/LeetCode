public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        // because of circle, we have two options: rob from 0 through n - 2; rob from 1 through n - 1
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    // the same as '198. House Robber'
    public int robHelper(int[] nums, int start, int end) {
        int yes = 0, no = 0;
        for(int i = start; i <= end; i++) {
            int tmp = no;
            no = Math.max(no, yes);
            yes = tmp + nums[i];
        }
        return Math.max(no, yes);
    }
}