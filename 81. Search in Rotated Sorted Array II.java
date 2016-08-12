public class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1, middle = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(nums[middle] == target) return true;
            if(nums[middle] > nums[right]) {
                if(nums[left] <= target && target < nums[middle]) right = middle;
                else left = middle + 1;
            } else if(nums[middle] < nums[right]) {
                if(nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle;
            } else {
                right--;
            }
        }
        return nums[left] == target;
    }
}