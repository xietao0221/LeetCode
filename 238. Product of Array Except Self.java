public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        
        // from left to right, for each num[i], calculate the product from 0 to i-1
        int left = 1;
        for(int i = 1; i < res.length; i++) {
            left *= nums[i - 1];
            res[i] = left;
        }
        
        // from right to left, for each num[i], calculate the product from n-1 to i+1
        int right = 1;
        for(int i = res.length - 2; i >= 0; i--) {
            right *= nums[i + 1];
            res[i] *= right; 
        }
        return res;
    }
}