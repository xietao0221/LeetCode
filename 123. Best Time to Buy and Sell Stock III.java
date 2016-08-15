/*
https://www.youtube.com/watch?v=oDhu5uGq_ic
dp[i][j] means the max profit which ending at transaction i and day j
(1) no transaction at day j: dp[i][j-1]
(2) sell at day j: (prices[j] - prices[m]) + dp[i-1][m] = prices[j] + (dp[i-1][m] - prices[m]) = prices[j] + diffMax (where m is from 0 to j-1)
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int[][] dp = new int[3][prices.length];
        for(int i=1; i<=2; i++) {
            int diffMax = dp[i-1][0] - prices[0];
            for(int j=1; j<prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1], prices[j] + diffMax);
                diffMax = Math.max(diffMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[2][prices.length - 1];
    }
}