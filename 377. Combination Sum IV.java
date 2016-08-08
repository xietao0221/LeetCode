// https://discuss.leetcode.com/topic/52302/1ms-java-dp-solution-with-detailed-explanation
// Imagine we only need one more number to reach target, this number can be any one in the array
// So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), 
// where 0 <= i < nums.length, and target >= nums[i].
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i=1; i<dp.length; i++) {
            for (int j=0; j<nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}