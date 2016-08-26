// https://www.youtube.com/watch?v=IFNibRVgFBo
// Time Complexity: O(n^3)
// Space Complexity: O(n^2)
public class Solution {
    public int maxCoins(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[][] dp = new int[nums.length][nums.length];
        
        // len is the range of calculation
        for(int len = 1; len <= nums.length; len++) {
            // the calculation range is [i, i + len - 1]
            // i is the index of leftmost balloon of this calculation range
            for(int i = 0; i <= nums.length - len; i++) {
                // j is the index of rightmost balloon of this calculation range
                int j = i + len - 1;
                // k is the index of last balloon to be bursted
                for(int k = i; k <= j; k++) {
                    // the default value of left/right-value is 1
                    int leftValue = 1, rightValue = 1;
                    
                    // if there is a valid left/right-value, change it
                    if(i != 0) leftValue = nums[i - 1];
                    if(j != nums.length - 1) rightValue = nums[j + 1];
                    
                    // whether there is any balloon bursted before or after k
                    int before = 0, after = 0;
                    if(k != i) before = dp[i][k - 1];
                    if(k != j) after = dp[k + 1][j];
                    
                    dp[i][j] = Math.max(dp[i][j], before + leftValue * nums[k] * rightValue + after);
                }
            }
        }
        return dp[0][nums.length - 1];
    }
}