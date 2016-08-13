// O(1) Space
public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0], maxEndingHere = nums[0];
        for(int i=1; i<nums.length; i++) {
            //maxEndingHere: decide start a new subarray or not
            //res: decide which subarray we will use so far
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            res = Math.max(res, maxEndingHere);
        }
        return res;
    }
}

// O(n) Space
/*
public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];        // dp[i] represents the max-sum ending at i-1
        int res = Integer.MIN_VALUE;                // res represents the max-sum ending from 0 to i-1
        for(int i=1; i<=nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
*/