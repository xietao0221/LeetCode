public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1, middle = 0;
        while(left < right) {
            middle = left + (right - left) / 2;
            if(nums[middle] > nums[right]) {
                // right part is unsorted, pivot point is on the right
                left = middle + 1;
            } else if(nums[middle] < nums[left]) {
                // left part is unsorted, pivot point is on the left
                right = middle;
            } else {
                // nums[left] <= nums[middle] <= nums[middle] => nums[left] = nums[middle] = nums[right]
                right--;
            }
        }
        return nums[left];
    }
}