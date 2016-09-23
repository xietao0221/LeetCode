/**
  0 1 2 3 4 5 6 7 8 9 10 11
1 0 1 2 3 4 5 6 7 8 9 10 11
5 0 1 2 3 4 1 2 3 4 5  2  3
6 0 1 2 3 4 1 1 2 3 4  2  2 
8 0 1 2 3 4 1 1 2 1 2  2  2
*/
// DP Solution
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++) dp[i] = Integer.MAX_VALUE;
        
        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j < dp.length; j++) {
                // if the 'previous one' is INF, we cannot use it
                if(j < coins[i] || dp[j - coins[i]] == Integer.MAX_VALUE) continue;
                dp[j] = Math.min(dp[j - coins[i]] + 1, dp[j]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}

// Recursive Approach
/*
public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return coinChangeHelper(coins, amount, memo);
    }
    
    public int coinChangeHelper(int[] coins, int amount, int[] memo) {
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(memo[amount] != 0) return memo[amount];
        
        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
            int result = coinChangeHelper(coins, amount - coin, memo) + 1;
            if(result > 0 && result < min) min = result;
        }
        memo[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[amount];
    }
}
*/