public class Solution {
    public List<String> knapsack(int[] values, int[] weights, int maxWeight) {
        int[][] dp = new int[values.length + 1][maxWeight + 1];

        // deal with the top-left cell
        dp[0][0] = 0;

        // deal with the res
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(weights[i - 1] > j) {
                    // cannot use the current item
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // could use the current item
                    dp[i][j] = Math.max(dp[i - 1][j], values[i - 1] + dp[i - 1][j - weights[i - 1]]);
                }
            }
        }

        // output the result
        List<String> res = new ArrayList<>();
        int i = dp.length - 1, j = dp[0].length - 1;
        while(i > 0 && j > 0) {
            if(dp[i][j] == dp[i - 1][j]) {
                // don't use item[i - 1]
                i--;
            } else {
                // use item[i - 1]
                res.add("values: " + values[i - 1] + " weights: " + weights[i - 1]);
                j -= weights[i - 1];
                i--;
            }
        }
        return res;
    }
}