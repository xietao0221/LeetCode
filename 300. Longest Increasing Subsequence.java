public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length < 1) return 0;
        int maxSoFar = 0;
        int[] dp = new int[nums.length];

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxSoFar = Math.max(maxSoFar, dp[i]);
        }
        return maxSoFar+1;
    }
}