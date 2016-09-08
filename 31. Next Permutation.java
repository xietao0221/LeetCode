//https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
/*
0 1 2 5 3 3 0
(1) find the longest non-increasing suffix: 0 1 2 [5 3 3 0]
(2) identify pivot: 2
(3) find the right most successor to pivot in the suffix and swap with pivot: 0 1 3 [5 3 2 0]
(4) reverse the suffix: 0 1 3 [0 2 3 5]
*/
public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) return;
        
        // from right->left, find the first non-increasing suffix(could be one element), one more left is the pivot
        // that means this suffix is the greatest, it need to be changed
        int pivot = nums.length - 2;
        while(pivot > 0 && nums[pivot] >= nums[pivot + 1]) pivot--;
        if(pivot == 0 && nums[pivot] >= nums[pivot + 1]) {
            reverseOrder(nums, 0, nums.length - 1);
            return;
        }
        
        // for this pivot, find the first element x for which x >= pivot
        int target = nums.length - 1;
        while (pivot < target && nums[pivot] >= nums[target]) target--;
        
        // swap pivot and this element
        int tmp = nums[pivot];
        nums[pivot] = nums[target];
        nums[target] = tmp;
        
        // reverse the suffix
        reverseOrder(nums, pivot + 1, nums.length - 1);
        return;
    }
    
    public void reverseOrder(int[] nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
        return;
    }
}