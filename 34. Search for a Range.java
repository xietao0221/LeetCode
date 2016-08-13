// https://discuss.leetcode.com/topic/5891/clean-iterative-solution-with-two-binary-searches-with-explanation
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int left = 0, right = nums.length - 1, middle = 0;
        
        // search for left bound
        while(left < right) {
            middle = left + (right - left) / 2;         // mid round to left
            if(nums[middle] < target) left = middle + 1;
            else right = middle;
        }
        if(nums[left] != target) return res;
        else res[0] = left;
        
        // search for right bound
        right = nums.length - 1;                        // mid round to right
        while(left < right) {
            middle = left + (right - left) / 2 + 1;
            if(nums[middle] > target) right = middle - 1;
            else left = middle;
        }
        res[1] = right;
        return res;
    }
}