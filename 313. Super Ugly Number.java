// the same as '264. Ugly Number II'
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] count = new int[primes.length];
        int[] dp = new int[n];
        dp[0] = 1;
        
        for(int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 0; j < count.length; j++) {
                dp[i] = Math.min(dp[i], dp[count[j]] * primes[j]);
            }
            
            for(int j = 0; j < count.length; j++) {
                if(dp[i] % primes[j] == 0) count[j]++;
            }
        }
        return dp[n - 1];
    }
}