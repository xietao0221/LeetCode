public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        if(nums.length < 3) return nums.length;
        
        int repeat = 0, index = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                repeat++;
                if(repeat <= 1) nums[index++] = nums[i];
            } else {
                nums[index++] = nums[i];
                repeat = 0;
            }
        }
        return index;
    }
}