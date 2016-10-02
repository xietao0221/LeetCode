public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 1) return nums[0] == val ? 0 : 1;
        
        int left = 0, right = nums.length - 1, count = 0;
        while(left <= right) {
            // ensure the value of left is non-val
            while(left <= right && nums[left] != val) left++;
            
            // ensure the value of right is val
            while(left <= right && nums[right] == val) {
                right--;
                count++;
            }
            
            // if left is val and right is non-val, swap them
            if(left < right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }
        return nums.length - count;
    }
}