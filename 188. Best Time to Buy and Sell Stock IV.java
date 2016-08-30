/*
https://www.youtube.com/watch?v=oDhu5uGq_ic
dp[i][j] means the max profit which ending at transaction i and day j
(1) no transaction at day j: dp[i][j-1]
(2) sell at day j: (prices[j] - prices[m]) + dp[i-1][m] = prices[j] + (dp[i-1][m] - prices[m]) = prices[j] + diffMax (where m is from 0 to j-1)
*/
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length < 1) return 0;
        
        // deal with k >= n/2, which means we can make as many transactions as we can
        // it is '122. Best Time to Buy and Sell Stock II' now
        if(k >= prices.length / 2) {
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                if(prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;    
        }
        
        int[][] dp = new int[k + 1][prices.length];
        // transaction 0 is always 0, and day 0 is always 0, so iterate from i=1, j=1
        for(int i = 1; i <= k; i++) {
            int diffMax = dp[i - 1][0] - prices[0];
            for(int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + diffMax);
                diffMax = Math.max(diffMax, dp[i - 1][j] - prices[j]);
            }
        }
        
        return dp[k][prices.length - 1];
    }
}