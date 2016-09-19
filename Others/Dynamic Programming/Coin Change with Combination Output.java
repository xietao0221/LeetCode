public class Solution {
    public List<Integer> coinChange(int[] coins, int amount) {
        // dp[i]: the smallest number of coins used for amount i
        // coinsCombination[i]: the newest index of coin used for amount i
        int[] dp = new int[amount + 1], coinsCombination = new int[amount + 1];
        List<Integer> res = new ArrayList<>();

        for(int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            coinsCombination[i] = -1;   // it's safe to use -1 as the default coin index
        }

        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j < dp.length; j++) {
                // if the 'previous one' is INF, we cannot use it
                if(j - coins[i] < 0 || dp[j - coins[i]] == Integer.MAX_VALUE) continue;
                if(dp[j - coins[i]] + 1 < dp[j]) {
                    dp[j] = dp[j - coins[i]] + 1;
                    // because of coins[i], we update the dp matrix, this coin is the potential result
                    coinsCombination[j] = i;
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE) {
            return res;
        } else {
            // from back to front
            while(amount > 0) {
                int curr = coins[coinsCombination[amount]];
                amount -= curr;
                res.add(curr);
            }
            return res;
        }
    }
}