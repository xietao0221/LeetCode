// https://www.youtube.com/watch?v=ih2OZ9-M3OM
/*

s1 = axy
s2 = aab
s3 = aaxaby

  0 a a b
0 T T T F
a T T F F
x F T T T
y F F F T

*/
// 2-D DP Matrix
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        char[] s1Array = s1.toCharArray(), s2Array = s2.toCharArray(), s3Array = s3.toCharArray();
        // dp[i][j] represents the result ending at s3[i + j - 1]
        boolean[][] dp = new boolean[s1Array.length + 1][s2Array.length +1];
        
        // deal with the top-left cell
        dp[0][0] = true;
        
        // deal with the first row
        for(int j = 1; j < dp[0].length; j++) {
            if(s3Array[j - 1] == s2Array[j - 1]) dp[0][j] = dp[0][j - 1];
            // the default valud is false, so don't need to set it up
        }
        
        // deal with the first col
        for(int i = 1; i < dp.length; i++) {
            if(s3Array[i - 1] == s1Array[i - 1]) dp[i][0] = dp[i - 1][0];
            // the default valud is false, so don't need to set it up
        }
        
        // iterate the rest
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                // if the character of s3 equals to the one of s1, remove this character from s1, and get the value
                if(s3Array[i + j - 1] == s1Array[i - 1]) dp[i][j] = dp[i - 1][j];
                
                // if the character of s3 equals to the one of s2, remove this character from s2, and get the value
                // don't forget to or the previous value
                if(s3Array[i + j - 1] == s2Array[j - 1]) dp[i][j] |= dp[i][j - 1];
                
                // otherwise dp[i][j] = false, don't need to set it up
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}