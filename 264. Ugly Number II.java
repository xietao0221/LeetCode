public class Solution {
    public int nthUglyNumber(int n) {
        // dp[i] means the (i+1)th ugly number, so as the result, we return dp[n - 1]
        int[] dp = new int[n];
        dp[0] = 1;
        
        int index2 = 0, index3 = 0, index5 = 0;
        for(int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[index2] * 2, Math.min(dp[index3] * 3, dp[index5] * 5));
            
            if(dp[i] % 2 == 0) index2++;
            if(dp[i] % 3 == 0) index3++;
            if(dp[i] % 5 == 0) index5++;
        }
        
        return dp[n - 1];
    }
}