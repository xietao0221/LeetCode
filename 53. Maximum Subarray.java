// Kadane Algorithm
public class Solution {
    public int maxSubArray(int[] nums) {
        // res is global maximum, decide whether start a new subarray or not
        // localMax is local maximum, decide which subarray we will use so far
        // because local maximum is always ending at i-1, but the final result cannot always ending at i-1
        // we need to use a global var to keep the max value
        int res = nums[0], localMax = nums[0];
        for(int i = 1; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            res = Math.max(res, localMax);
        }
        return res;
    }
}