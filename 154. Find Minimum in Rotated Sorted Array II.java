public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(nums[middle] > nums[right]) {
                left = middle + 1;
            } else if(nums[left] < nums[middle]) {
                right = middle;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}