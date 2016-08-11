public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow=0, fast=1;
        for(fast=1; fast<nums.length; fast++) {
            if(nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        return slow + 1;
    }
}