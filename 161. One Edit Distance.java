/*
 * There're 3 possibilities to satisfy one edit distance apart: 
 * 
 * 1) Replace 1 char:
    s: a B c
    t: a D c
 * 2) Delete 1 char from s: 
    s: a D  b c
    t: a    b c
 * 3) Delete 1 char from t
    s: a   b c
    t: a D b c
 */
// string solution
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length() - t.length()) > 1) return false;
        
        int len = Math.min(s.length(), t.length());
        for(int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)) {       // detect one potential edit
                // replace: remove i from both strings
                if(s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
                
                // delete 1 char from s: remove i from t and compare again
                if(s.length() < t.length()) return s.substring(i).equals(t.substring(i + 1));
                
                // delete 1 char from t: remove i from s and compare again
                if(s.length() > t.length()) return s.substring(i + 1).equals(t.substring(i));    
            }
        }
        // if all char of (position <= minLen) are all the same, check if the difference of their length is ONE
        return Math.abs(s.length() - t.length()) == 1;
    }
}

// DP Solution
/*
public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        char[] sArray = s.toCharArray(), tArray = t.toCharArray();
        int[][] dp = new int[sArray.length + 1][tArray.length + 1];
        
        // deal with the first row
        for(int j = 1; j <= tArray.length; j++) dp[0][j] = j;
        
        // deal with the first col
        for(int i = 1; i <= sArray.length; i++) dp[i][0] = i;
        
        // deal with the rest
        for(int i = 1; i <= sArray.length; i++) {
            for(int j = 1; j <= tArray.length; j++) {
                if(sArray[i - 1] == tArray[j - 1]) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
            }
        }
        return dp[sArray.length][tArray.length] == 1;
    }
}
*/