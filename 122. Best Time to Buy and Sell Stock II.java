// Solution1
// 1 2 3 0 1 3 2 6
// ----- ----- ---
public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] >= prices[i - 1]) res += prices[i] - prices[i - 1];
        }
        return res;
    }
}

// Solution2
/*
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int res = 0, index = 0, minPrice = 0;
        while(index < prices.length) {
            // find the local min-price
            while(index < prices.length - 1 && prices[index] >= prices[index + 1]) index++;
            if(index < prices.length) minPrice = prices[index++];
            
            // find the local max-price
            while(index < prices.length - 1 && prices[index] <= prices[index + 1]) index++;
            if(index < prices.length) res += prices[index++] - minPrice;
        }
        return res;
    }
}
*/