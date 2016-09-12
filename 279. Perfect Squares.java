/*
dp[0] = 0
dp[1] = dp[0] + 1 = 1
dp[2] = dp[2 - 1^2] + 1 = 2
dp[3] = dp[3 - 1^2] + 1 = 3
dp[4] = min(dp[4 - 1^2] + 1, dp[4 - 2^2] + 1) = 1
dp[5] = min(dp[5 - 1^2] + 1, dp[5 - 2^2] + 1) = 2
dp[n] = min(dp[n - i^2] + 1), where n - i^2 >= 0 && i >= 1
*/
public class Solution {
    public int numSquares(int n) {
        // dp[i] represents the number of perfect square numbers for i
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}