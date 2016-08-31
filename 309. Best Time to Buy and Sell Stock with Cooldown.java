/*
https://discuss.leetcode.com/topic/30421/share-my-thinking-process/2

buy[i] = max(buy[i - 1], rest[i - 1] - price)
sell[i] = max(sell[i - 1], buy[i - 1] + price)
rest[i] = max(res[i - 1], sell[i - 1])

because of rest[i - 1] = sell[i - 2]
then

buy[i] = max(buy[i - 1], sell[i - 2] - price)
sell[i] = max(sell[i - 1], buy[i - 1] + price)
*/
// 1D DP
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        
        int[] buy = new int[prices.length], sell = new int[prices.length];
        
        buy[0] = -prices[0];    // buy at day0, it is -price
        sell[0] = 0;            // sell at day0, no possible, so it is 0
        
        for(int i = 1; i < prices.length; i++) {
            buy[i] = Math.max(buy[i - 1], i - 2 >= 0 ? sell[i - 2] - prices[i] : -prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
        }
        return sell[prices.length - 1];
    }
}


// O(n) space to O(1) space
public class Solution {
    public int maxProfit(int[] prices) {
        int buyPrev = 0, sellPrev = 0, buyCurr = Integer.MIN_VALUE, sellCurr = 0;
        for(int price: prices) {
            buyPrev = buyCurr;
            buyCurr = Math.max(sellPrev - price, buyPrev);
            sellPrev = sellCurr;
            sellCurr = Math.max(buyPrev + price, sellPrev);
        }
        return sellCurr;
    }
}