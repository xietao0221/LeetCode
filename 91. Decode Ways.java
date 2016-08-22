public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        char[] sArray = s.toCharArray();
        // dp[] represents the number of ways starting at i
        int[] dp = new int[s.length() + 1];
        dp[sArray.length] = 1;
        dp[sArray.length - 1] = sArray[sArray.length - 1] == '0' ? 0 : 1;
        
        for(int i = sArray.length - 2; i >= 0; i--) {
            if(sArray[i] == '0') continue;
            
            int tmp = 10 * (sArray[i] - '0') + (sArray[i + 1] - '0');
            if(tmp <= 26) dp[i] = dp[i + 1] + dp[i + 2];
            else dp[i] = dp[i + 1];
        }
        return dp[0];
    }
}