// http://www.cnblogs.com/springfor/p/3896152.html
// 2-D DP Matrix
public class Solution {
    public int numDistinct(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        // deal with s and t are both empty string
        dp[0][0] = 1;
        
        // deal with s is empty string but t is not
        for(int j = 1; j < dp[0].length; j++) dp[0][j] = 0;
        
        // deal with t is empty string but s is not
        for(int i = 1; i < dp.length; i++) dp[i][0] = 1;
        
        // iterate the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // dp[i][j] at least equals to dp[i-1][j], because the increasement of s cannot 'hurt' dp value
                if(sArray[i - 1] == tArray[j - 1]) {
                    // (1) use this information, this two characters can be removed, dp[i][j] += dp[i-1][j-1]
                    // (2) don't use this information, just remove s's character, dp[i][j] += dp[i-1][j] (we cannot
                    // DO NOT remove t's character, because t is the target, we need to remove some characters in s)
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // the new s's character is useless, just remove it
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}