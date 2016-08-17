public class Solution {
    public void moveZeroes(int[] nums) {
        int anchor = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[anchor++] = nums[i];
        }
        while(anchor < nums.length) {
            nums[anchor++] = 0;
        }
        
    }
}