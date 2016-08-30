/*
https://www.youtube.com/watch?v=YDf982Lb84o
n = 0: dp[0] = 0
n = 1: dp[1] = 1
n = 2: dp[2] = 2
n = 3: dp[3] = dp[2] + dp[1] * dp[1] + dp[2]
n = 4: dp[4] = dp[3] + dp[1] * dp[2] + dp[2] * dp[1] + dp[3]
n = 5: dp[5] = dp[4] + dp[1] * dp[3] + dp[2] * dp[2] + dp[3] * dp[1] + dp[4]
*/
public class Solution {
    public int numTrees(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] dp = new int[n + 1];
        dp[0] = 0; dp[1] = 1; dp[2] = 2;
        
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i - 2; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
            dp[i] += 2 * dp[i - 1];
        }
        return dp[n];
    }
}