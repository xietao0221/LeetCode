/**
 * Merge Sort
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 * Use Divide and Conquer Method: divide the array in half, sorts each of those halves, and then merge them back
 * together.
 * */
public class Solution {
    public void mergeSort(int[] nums) {
        int[] helper = new int[nums.length];
        mergeSort(nums, helper, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int[] helper, int left, int right) {
        if(left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, helper, left, mid);
            mergeSort(nums, helper, mid + 1, right);
            merge(nums, helper, left, mid + 1, right);
        }
    }

    private void merge(int[] nums, int[] helper, int leftStart, int rightStart, int rightEnd) {
        int leftEnd = rightStart - 1, anchor = leftStart, len = rightEnd - leftStart + 1;

        while(leftStart <= leftEnd && rightStart <= rightEnd) {
            helper[anchor++] = nums[leftStart] <= nums[rightStart] ? nums[leftStart++] : nums[rightStart++];
        }

        // Copy rest of left half and right half
        while(leftStart <= leftEnd) helper[anchor++] = nums[leftStart++];
        while(rightStart <= rightEnd) helper[anchor++] = nums[rightStart++];

        // Copy helper back, have to copy from rightEnd because other vars are changed
        for(int i = 0; i < len; i++) {
            nums[rightEnd] = helper[rightEnd--];
        }
    }
}