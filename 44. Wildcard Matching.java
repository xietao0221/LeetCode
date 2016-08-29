// https://www.youtube.com/watch?v=3ZDZ-N0EPV0
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray(), pArray = p.toCharArray();
        
        // replace multiple * with single *
        int left = 0, right = 0;
        while(right < pArray.length) {
            pArray[left++] = pArray[right++];
            if(pArray[right - 1] == '*') {
                while(right < pArray.length && pArray[right] == '*') right++;    
            }
        }
        
        // initiate dp array
        int m = sArray.length, n = left;
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // s and p are all empty, they match
        dp[0][0] = true;
        
        // deal with the first row and first col, the default value is false, so do nothing with it
        
        // deal with s is empty, but p is *, they match
        if(n > 0 && pArray[0] == '*') dp[0][1] = true;
        
        for(int i = 1; i < m + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                // add j>0 to make first column false, because pattern is empty but text is not
                if(j > 0 && (sArray[i - 1] == pArray[j - 1] || pArray[j - 1] == '?')) {
                    // p and s is the same, or they can be seen as the same because of '?'
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(j > 0 && pArray[j - 1] == '*') {
                    // (1) if * maches 0 characters, this j can be removed, dp[i][j] |= dp[i][j-1]
                    // (2) if * maches >= 1 characters(could be anything), this i can be removed, dp[i][j] |= dp[i-1][j]
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[m][n];
    }
}