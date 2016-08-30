/*
https://www.youtube.com/watch?v=oDhu5uGq_ic
dp[i][j] means the max profit which ending at transaction i and day j
(1) no transaction at day j: dp[i][j-1]
(2) sell at day j: (prices[j] - prices[m]) + dp[i-1][m] = prices[j] + (dp[i-1][m] - prices[m]) = prices[j] + diffMax (where m is from 0 to j-1)
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 1) return 0;
        int[] dp = new int[prices.length];
        
        // because there is only one transaction, so do not have the outer loop(for transactions)
        int diffMax = dp[0] - prices[0];
        for(int j = 1; j < prices.length; j++) {
            dp[j] = Math.max(dp[j - 1], prices[j] + diffMax);
            diffMax = Math.max(diffMax, -prices[j]);    // dp[i-1][m] is not exist, so it is 0
        }
        return dp[prices.length - 1];
    }
}