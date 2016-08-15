// DP Solution
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] dp = new int[prices.length];
        int minPrice = prices[0];
        for(int i=1; i<prices.length; i++) {
            // find the max-profit ending at i: (1)have nothing to do with i; (2)sell at i
            dp[i] = Math.max(dp[i-1], prices[i] - minPrice);
            // always find the minPrice
            minPrice = Math.min(minPrice, prices[i]);
        }
        return dp[prices.length - 1];    
    }
}

// Kadane Algorithm
/*
public class Solution {
    public int maxProfit(int[] prices) {
        int maxCurr = 0, res = 0;
        for(int i=1; i<prices.length; i++) {
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i-1]);
            res = Math.max(res, maxCurr);
        }
        return res;
    }
}
*/